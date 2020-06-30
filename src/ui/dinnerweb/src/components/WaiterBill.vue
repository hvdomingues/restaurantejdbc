<template>
  <div id="div-principal">
    <button v-on:click="voltar()">Voltar</button>
    <h3 v-if="individualbills.length === 0">Não há contas individuais cadastradas.</h3>
    <div class="row" v-else>
      <div class="col-sm-3" v-for="individualBill in individualbills" :key="individualBill.id">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Lugar da mesa: {{ individualBill.tabPosition }}</h5>
            <h5
              v-if="individualBill.observation != null"
            >Observation: {{individualBill.observation}}</h5>
            <a class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BillService from "../services/individualBills";

export default {
  name: "WaiterBill",
  data() {
    return {
      individualbills: []
    };
  },
  props: {
    bill: {
      type: Object,
      required: true
    }
  },
  created() {
    this.getIndBills();
  },
  methods: {
    voltar() {
      this.$emit("voltar");
    },
    getIndBills() {
      BillService.listByBillID(this.bill.id)
        .then(response => {
          
            this.individualbills = response.data;
          
            
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>

<style scoped>
#div-principal {
  margin: 30px;
}
</style>