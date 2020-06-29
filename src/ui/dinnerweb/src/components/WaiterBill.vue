<template>
  <div>
    <button type="button" class="btn btn-primary">{{bill}}</button>
  </div>
</template>

<script>
export default {
  name: "WaiterBill",
  props: {
    bill: {
      type: Object,
      required: true
      // default: 'Lucas'
    }
  }
};
</script>