<template>
  <div>
    <div v-show="principalOrders" class="text-center">
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
        <button class="btn btn-outline-secondary">
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

      <h3 v-if="orders.length === 0">Ainda nao há pedidos registrados.</h3>
      <div class="row" v-else>
        <div class="col-sm-3" style="margin-top:10px" v-for="order in orders" :key="order.id">
          <div class="card">
            <div class="card-body">
              <a class="btn btn-primary">Abrir</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "IndividualOrders",
  props: {
    individualBill: {
      type: Object,
      required: true
    }
  },
  data(){
      return{
          principalOrders: true,
          orders: this.individualBill.orders
      }
  },
  methods: {
    voltar() {
      this.$emit("voltar");
    }
  }
};
</script>