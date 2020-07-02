<template>
  <div id="div-principal" class="text-center">
    <div class="btn-group" role="group" style="margin: 30px">
      <button v-on:click="voltar()" class="btn btn-outline-secondary">Voltar</button>
      <button
        id="modal-215075"
        href="#modal-container-215075"
        role="button"
        class="btn btn-outline-secondary"
        data-toggle="modal"
      >Adicionar</button>
    </div>

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
    <div
      class="modal fade"
      id="modal-container-215075"
      role="dialog"
      aria-labelledby="myModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="myModalLabel">Conta individual</h5>
            <button type="button" class="close" data-dismiss="modal">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <form @submit="checkForm()" v-on:submit.prevent role="form">
            <div class="modal-body">
              <h3 class="text-primary">Nova conta individual</h3>
              <div class="form-group">
                <label for="tabPosition">Lugar na mesa</label>
                <input type="number" min="1" class="form-control" v-model="tabPosition" />
              </div>
              <div class="form-group">
                <label for="observation">Observação</label>
                <input type="text" maxlength="50" class="form-control" v-model="observation" />
                <div class="alert alert-success alert-dismissable" style="margin-top:20px" v-if="mensagemErro != null">
                  <button type="button" class="close" data-dismiss="alert" v-on:click="mensagemErro = null" aria-hidden="true">×</button>
                  <strong> {{mensagemErro}} </strong>
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="submit" class="btn btn-primary">Salvar</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </form>
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
      individualbills: [],
      tabPosition: "0",
      observation: null,
      mensagemErro: null
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
    },
    checkForm() {
      if (this.tabPosition <= 0 || this.tabPosition === null) {
        this.mensagemErro = "Digite um número de mesa maior que 0.";
      } else {
        BillService.createIndBill(this.observation,this.tabPosition,this.bill.id)
        .then(response=>{
          console.log(response.data)
          this.mensagemErro = "Não tem erro, deu certo, depois mudo a lógica";
          this.getIndBills();
        })
        .catch(error =>{
          this.mensagemErro = error.response.data.message;
        })
      }
    }
  }
};
</script>

<style scoped>
#div-principal {
  margin: 30px;
}
</style>