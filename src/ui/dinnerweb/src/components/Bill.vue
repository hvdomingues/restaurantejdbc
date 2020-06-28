<template>
  <div>
    <div class="btn-group" role="group" style="margin: 30px" aria-label="Exemplo básico">
      <button type="button" class="btn btn-outline-secondary" v-on:click="getBills()">Atualizar</button>
      <button type="button" class="btn btn-outline-secondary" v-on:click="changeBillType()">
        Ver contas
        <span v-if="billType">inativas</span>
        <span v-else>ativas</span>
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
        <div class="col-sm-3" v-for="bill in bills" :key="bill.id">
          <div class="card">
            <div class="card-body">
              <!-- Se for conta ativa mostra pelo número da mesa, caso seja conta inativa mostra pelo ID da conta -->
              <h5 class="card-title" v-if="billType">
                <img src="../assets/table.png" class="icone" width="20" height="25" />
                Mesa: {{ bill.tableNumber }}
              </h5>
              <h5 class="card-title" v-if="!billType">
                <img src="../assets/table.png" class="icone" width="20" height="25" />
                Conta: {{ bill.id }}
              </h5>
              <a href="#" class="btn btn-primary">Go somewhere</a>
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
          <form>
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Digite o número da mesa:</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <input type="number" placeholder="Número da mesa" v-model="numeroMesa">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <button type="button" v-on:click="createBill()" class="btn btn-primary">Save changes</button>
            </div>
          </div>
          </form>
        
      </div>
    </div>
  </div>
</template>


<script>
import BillService from "../services/bills.js";

export default {
  name: "Bill",
  data() {
    return {
      bills: null,
      loading: true,
      errored: false,
      billType: true,
      numeroMesa: null
    };
  },
  created() {
    this.getBills();
  },
  methods: {
    getBills() {
      this.loading = true;
      if (this.billType) {
        BillService.listActive()
          .then(response => {
            this.bills = response.data;
          })
          .catch(error => {
            console.log(error);
            this.errored = true;
          })
          .finally(() => (this.loading = false));
      } else {
        BillService.listInactive()
          .then(response => {
            this.bills = response.data;
          })
          .catch(error => {
            console.log(error);
            this.errored = true;
          })
          .finally(() => (this.loading = false));
      }
    },
    changeBillType() {
      if (this.billType) {
        this.billType = false;
      } else {
        this.billType = true;
      }
      this.getBills();
    },
    createBill() {
      BillService.create(this.numeroMesa).then(response =>{
        console.log(response.data);
         this.numeroMesa = null;
      }).catch(error => {
            console.log(error);
          })
          
     
    }
  }
};
</script>

<style>
.icone {
  margin-right: 5px;
  margin-bottom: 2px;
}
</style>