<template>
  <div class="container-fluid" style="min-width: 250px;">
    <v-row justify="center">
      <v-expansion-panels accordion>
        <v-expansion-panel v-for="category in categories" :key="category.id">
          <v-expansion-panel-header>
            <h3>{{category.name}}</h3>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <div class="row" v-for="product in category.products"
                  :key="product.id">
              <div class="col-sm-6">
                <h6
                >{{product.name}} - R${{product.price}}</h6>
              </div>
              <div class="col-sm-6 text-right">Adicionar</div>
            </div>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-row>
  </div>
</template>




<script>
import MenuService from "../services/menu.js";

export default {
  name: "Menu",
  data() {
    return {
      categories: []
    };
  },
  methods: {
    getAll() {
      MenuService.listAll()
        .then(response => {
          this.categories = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  created() {
    this.getAll();
  },
  computed: {
    items() {
      return this.categories;
    }
  }
};
</script>
