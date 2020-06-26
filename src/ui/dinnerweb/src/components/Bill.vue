<template>
  <div>
    <button v-on:click="getBills()">Atualizar</button>
    <section v-if="errored">
      <p>Pedimos desculpas, não estamos conseguindo recuperar as informações no momento. Por favor, tente novamente mais tarde.</p>
    </section>

    <section v-else>
      <div v-if="loading">Carregando...</div>
      <div v-for="bill in sortedBills" :key="bill.id">
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
      sortedBills: null,
      loading: true,
      errored: false
    };
  },
  created() {
    this.getBills();
  },
  methods: {
    compare(a, b) {
      var keyA = a.tableNumber,
        keyB = b.tableNumber;
      // Compare
      if (keyA < keyB) return -1;
      if (keyA > keyB) return 1;
      return 0;
    },
    getBills() {
      this.loading = true;
      axios
        .get(dataURL + "/active")
        .then(response => {
          this.bills = response.data;
          this.sortedBills = this.bills.sort(this.compare);
        })
        .catch(error => {
          console.log(error);
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  }
};
</script>
