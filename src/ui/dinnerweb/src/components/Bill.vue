<template>
  <div>
    <div class="btn-group" role="group" style="margin: 30px" aria-label="Exemplo básico">
    <button type="button" class="btn btn-outline-secondary" v-on:click="getBills()">Atualizar</button>
    <button type="button" class="btn btn-outline-secondary" v-on:click="changeBillType()">Ver contas {{tipoConta}}</button>
    </div>
    <section v-if="errored">
      <p>Pedimos desculpas, não estamos conseguindo recuperar as informações no momento. Por favor, tente novamente mais tarde.</p>
    </section>

    <section v-else>
      <div v-if="loading">Carregando...</div>
      <div class="row" >
        <div class="col-sm-3" v-for="bill in bills" :key="bill.id">
          <div class="card">
            <div class="card-body">
              <!-- Se for conta ativa mostra pelo número da mesa, caso seja conta inativa mostra pelo ID da conta -->
              <h5 class="card-title" v-if="tipoConta==='inativas'"><img src="../assets/table.png" class="icone" width="20" height="25">Mesa: {{ bill.tableNumber }}</h5>
              <h5 class="card-title" v-if="tipoConta==='ativas'"><img src="../assets/table.png" class="icone" width="20" height="25">Conta: {{ bill.id }}</h5>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div>
        </div>
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
      billType: "/active",
      tipoConta: "inativas"
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
    changeBillType() {
      if (this.billType === "/active") {
        this.billType = "/inactive";
        this.tipoConta = "ativas"
      } else if (this.billType === "/inactive") {
        this.billType = "/active";
        this.tipoConta = "inativas"
      }
      this.getBills();
    }
  }
};
</script>

<style>
  .icone{
    margin-right: 5px;
    margin-bottom: 2px;
  }
</style>