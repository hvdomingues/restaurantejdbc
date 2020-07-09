<template>
  <div  style="width:100%">
    <div v-show="principalInd" class="text-center">
      <div class="btn-group" role="group" style="margin: 30px">
        <button v-on:click="voltar()" class="btn btn-outline-secondary">
          <svg
            width="1em"
            height="1em"
            viewBox="0 0 16 16"
            class="bi bi-arrow-return-left"
            fill="currentColor"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M5.854 5.646a.5.5 0 0 1 0 .708L3.207 9l2.647 2.646a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"
            />
            <path
              fill-rule="evenodd"
              d="M13.5 2.5a.5.5 0 0 1 .5.5v4a2.5 2.5 0 0 1-2.5 2.5H3a.5.5 0 0 1 0-1h8.5A1.5 1.5 0 0 0 13 7V3a.5.5 0 0 1 .5-.5z"
            />
          </svg>
        </button>
        <button
          id="modal-215075"
          href="#modal-container-215075"
          role="button"
          class="btn btn-outline-secondary"
          data-toggle="modal"
        >
          <svg
            width="1em"
            height="1em"
            viewBox="0 0 16 16"
            class="bi bi-plus"
            fill="currentColor"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M8 3.5a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5H4a.5.5 0 0 1 0-1h3.5V4a.5.5 0 0 1 .5-.5z"
            />
            <path
              fill-rule="evenodd"
              d="M7.5 8a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0V8z"
            />
          </svg>
        </button>
      </div>

      <h3 v-if="individualbills.length === 0">Não há contas individuais cadastradas.</h3>
      <div class="row" v-else>
        <div
          class="col-sm-3"
          style="margin-top:10px"
          v-for="(individualBill,index) in individualbills"
          :key="individualBill.id"
        >
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Lugar da mesa: {{ individualBill.tabPosition }}</h5>
              <h6
                v-if="individualBill.observation != 'null'"
              >Observation: {{individualBill.observation}}</h6>
              <a class="btn btn-primary" v-on:click="showOrders(index)">Pedidos</a>
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
                  <div
                    class="alert alert-success alert-dismissable"
                    style="margin-top:20px"
                    v-if="mensagemErro != null"
                  >
                    <button
                      type="button"
                      class="close"
                      data-dismiss="alert"
                      v-on:click="mensagemErro = null"
                      aria-hidden="true"
                    >×</button>
                    <strong>{{mensagemErro}}</strong>
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
    <IndividualOrders v-on:voltar="principalInd= true; getIndBills()" v-if="!principalInd" :individualBill="individualbills[index]" />
  </div>
</template>

<script>
import BillService from "../services/individualBills";
import IndividualOrders from "./IndividualOrders.vue";

export default {
  name: "WaiterBill",
  data() {
    return {
      individualbills: [],
      tabPosition: null,
      observation: null,
      mensagemErro: null,
      principalInd: true,
      index: null
    };
  },
  props: {
    bill: {
      type: Object,
      required: true
    }
  },
  components:{
    IndividualOrders
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
        BillService.createIndBill(
          this.observation,
          this.tabPosition,
          this.bill.id
        )
          .then(response => {
            console.log(response.data);
            this.mensagemErro = "Não tem erro, deu certo, depois mudo a lógica";
            this.getIndBills();
          })
          .catch(error => {
            this.mensagemErro = error.response.data.message;
          });
      }
    },
    showOrders(index) {
      this.index = index;
      this.principalInd = false;
    }
  }
};
</script>

<style scoped>
#div-principal {
  margin: 30px;
}
</style>