<template>
  <div id="div-principal"  style="width:100%">
    <div v-show="principal" class="text-center">
      <div class="btn-group" role="group" style="margin: 30px" aria-label="Exemplo básico">
        <button type="button" class="btn btn-outline-secondary" v-on:click="getBills()">
          <svg
            width="1em"
            height="1em"
            viewBox="0 0 16 16"
            class="bi bi-arrow-repeat"
            fill="currentColor"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M2.854 7.146a.5.5 0 0 0-.708 0l-2 2a.5.5 0 1 0 .708.708L2.5 8.207l1.646 1.647a.5.5 0 0 0 .708-.708l-2-2zm13-1a.5.5 0 0 0-.708 0L13.5 7.793l-1.646-1.647a.5.5 0 0 0-.708.708l2 2a.5.5 0 0 0 .708 0l2-2a.5.5 0 0 0 0-.708z"
            />
            <path
              fill-rule="evenodd"
              d="M8 3a4.995 4.995 0 0 0-4.192 2.273.5.5 0 0 1-.837-.546A6 6 0 0 1 14 8a.5.5 0 0 1-1.001 0 5 5 0 0 0-5-5zM2.5 7.5A.5.5 0 0 1 3 8a5 5 0 0 0 9.192 2.727.5.5 0 1 1 .837.546A6 6 0 0 1 2 8a.5.5 0 0 1 .501-.5z"
            />
          </svg>
        </button>
        <button
          type="button"
          class="btn btn-outline-secondary"
          data-toggle="modal"
          data-target="#exampleModal"
        >Abrir conta</button>
      </div>
      <section v-if="errored">
        <p>Pedimos desculpas, não estamos conseguindo recuperar as informações no momento. Por favor, tente novamente mais tarde.</p>
      </section>

      <section v-else>
        <div v-if="loading">Carregando...</div>
        <div class="row">
          <div
            class="col-sm-3"
            v-for="(bill, index) in bills"
            :key="bill.id"
            style="margin-top:10px"
          >
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">
                  <img src="../assets/table.png" class="icone" width="20" height="25" />
                  Mesa: {{ bill.tableNumber }}
                </h5>
                <a class="btn btn-primary" v-on:click="showBill(index)">Contas individuais</a>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Modal -->
      <div
        class="modal fade"
        id="exampleModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Digite o número da mesa:</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <input type="number" min="1" placeholder="Número da mesa" v-model="numeroMesa" />
              <h6 v-if="errorMessage != null" style="margin: 10px">{{errorMessage}}</h6>
              <h6 v-if="sucess" style="margin: 10px">Conta criada com sucesso.</h6>
            </div>
            <div class="modal-footer">
              <button
                id="closeButton"
                type="button"
                v-on:click="errorMessage=null"
                class="btn btn-secondary"
                data-dismiss="modal"
              >Close</button>
              <button type="button" v-on:click="createBill()" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <WaiterBill v-on:voltar="principal= true; getBills()" :bill="bills[index]" v-if="!principal" />
  </div>
</template>


<script>
import BillService from "../services/bills.js";
import WaiterBill from "./WaiterBill.vue";

export default {
  name: "Bill",
  data() {
    return {
      bills: null,
      loading: true,
      errored: false,
      numeroMesa: null,
      errorMessage: null,
      sucess: false,
      principal: true,
      index: null
    };
  },
  created() {
    this.getBills();
  },
  components: {
    WaiterBill
  },
  methods: {
    getBills() {
      this.loading = true;
      BillService.listActive()
        .then(response => {
          this.bills = response.data;
          this.errored = false;
        })
        .catch(error => {
          console.log(error);
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    createBill() {
      if (this.numeroMesa >= 1) {
        BillService.create(this.numeroMesa)
          .then(response => {
            console.log(response.data);
            this.numeroMesa = null;
            this.errorMessage = null;
            this.sucess = true;
            this.getBills();
          })
          .catch(error => {
            this.errorMessage = error.response.data.message;
            this.numeroMesa = null;
          });
      } else if (this.numeroMesa <= 0) {
        this.errorMessage = "Digite um número maior que zero, por favor.";
      } else {
        this.errorMessage = "Digite o número da mesa, por favor.";
      }
    },
    showBill(index) {
      this.index = index;
      this.principal = false;
    }
  }
};
</script>

<style scoped>
.icone {
  margin-right: 5px;
  margin-bottom: 2px;
}
</style>