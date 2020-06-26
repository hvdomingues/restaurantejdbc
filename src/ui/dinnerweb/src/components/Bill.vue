<template>
  <div>
    <button v-on:click="getBills()">Atualizar</button>
    <button v-on:click="changeBillType()">Change</button>
    <section v-if="errored">
      <p>Pedimos desculpas, não estamos conseguindo recuperar as informações no momento. Por favor, tente novamente mais tarde.</p>
    </section>

    <section v-else>
      <div v-if="loading">Carregando...</div>
      <div v-for="bill in bills" :key="bill.id">
        <span>
          Bill ID:
          <strong>{{ bill.id }}</strong>
          TableNumber: {{bill.tableNumber}}
        </span>
      </div>
    </section>
  </div>
</template>


<script>
import axios from "axios";

var dataURL = "http://localhost:8080/bills";

export default {
  name: "Bill",
  data() {
    return {
      bills: null,
      loading: true,
      errored: false,
      billType: "/active"
    };
  },
  created() {
    this.getBills();
  },
  methods: {
    getBills() {
      this.loading = true;
      axios
        .get(dataURL + this.billType)
        .then(response => {
          this.bills = response.data;
        })
        .catch(error => {
          console.log(error);
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    changeBillType(){
      if(this.billType === "/active"){
        this.billType = "/inactive";
      }
      else if(this.billType === "/inactive"){
        this.billType = "/active";
      }
      this.getBills();
    }
  }
};
</script>
