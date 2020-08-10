<template>
  <div>
    <div id="topo" class="text-center">
      
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
        
      
    </div>
    <v-row justify="center">
      <v-expansion-panels accordion>
        <v-expansion-panel v-for="(item,index) in itens" :key="index">
          <v-expansion-panel-header>
            <h5>{{item.find(x => x.id > '0').product.name}}</h5>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <h6 v-for="(orderItem,index) in item" :key="orderItem.id">#{{index + 1}} {{orderItem.status}} {{orderItem.observation}}</h6>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-row>

  </div>
</template>

<script>


export default {
  name: "Order",

  props: {
    order: {
      type: Object,
      required: true
    }
  },
  components:{

  },
  data() {
    return {
      orderItens: [],
      itens: [],
    };
  },
  methods: {
    voltar() {
      this.$emit("voltar");
    },
    organizarItens() {
      

        //Organiza por produto
      let orderedByProduct = this.orderItens.sort((a, b) => {
        if (a.product.id < b.product.id) {
          return -1;
        } else if (a > b) {
          return 1;
        }
        return 0;
      });

      let indexProduct = orderedByProduct[0].product.id;
      let itensIguais = [];
        //Se o ID for igual, adiciona a um novo array e da push no array de arrays
      orderedByProduct.forEach(element => {
          if(element.product.id === indexProduct){
              itensIguais.push(element);
          }else{
              indexProduct = element.product.id;
              this.itens.push(itensIguais);
              itensIguais = [];
              itensIguais.push(element);
          }
      });
      this.itens.push(itensIguais);
    }
  },
  created() {
    this.orderItens = this.order.orderItem;
    this.organizarItens();
  }
};
</script>