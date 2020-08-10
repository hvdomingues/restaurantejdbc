<template>
  <div class="container-fluid" style="min-width: 250px;">
    <v-row justify="center">
      <div class="col-sm-12"><h3>Menu</h3></div>
      <v-expansion-panels accordion>
        <v-expansion-panel v-for="(category, index) in categories" :key="category.id">
          <v-expansion-panel-header>
            <h3>{{category.name}}</h3>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <div class="row" v-for="(product, index2) in category.products" :key="product.id">
              <div class="col-sm-6">
                <h6>{{product.name}} - R${{product.price}}</h6>
              </div>
              <div class="col-sm-6 text-right">
                <button v-on:click="removeItem(index + index2)" class="btn btn-outline-secondary">-</button> 
                {{qtdProdutos[index + index2]}} 
                <button v-on:click="addItem(index + index2)" class="btn btn-outline-secondary">+</button>
              </div>
            </div>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-row>
    <div class="row text-center">
      <div class="col-sm-6">
        <h4>Cancelar</h4>
      </div>
      <div class="col-sm-6">
        <h4>Adicionar</h4>
      </div>
    </div>
  </div>
</template>




<script>
import MenuService from "../services/menu.js";

export default {
  name: "Menu",
  data() {
    return {
      categories: [],
      qtdProdutos: [],

    };
  },
  methods: {
    getAll() {
      MenuService.listAll()
        .then(response => {
          this.categories = response.data;
          this.categories.forEach(category => {
            category.products.forEach(product => {
              if(product != null){
                this.qtdProdutos.push(0);
              }
              
            });
          });
        })
        .catch(error => {
          console.log(error);
        });
    },
    addItem(indexItem){
      console.log("chegou aqui " + indexItem);
      this.qtdProdutos[indexItem] = this.qtdProdutos[indexItem] + 1;
  
      
    },
    removeItem(indexItem){
      if(this.qtdProdutos[indexItem] > 0){
        console.log("Não chegou aquui");
      }
    }
  },
  created() {
    this.getAll();
  }
};
</script>
