<template>
  <div>
    <h1>Рейс {{depart.name}} - {{arrive.name}} {{query.date}}</h1>
  <table class="table table-striped my-5">
    <thead>
    <tr>
      <th scope="col">Отправление</th>
      <th scope="col">Прибытие</th>
      <th scope="col">Рейс</th>
      <th scope="col">Места</th>
      <th scope="col"></th>
    </tr>
    </thead>
    <tbody v-for="item in items">
      <RoutingTableRow v-bind:voyage="item"></RoutingTableRow>
    </tbody>
  </table>
  </div>
</template>

<script>
import RoutingTableRow from "@/components/RoutingTableRow";
export default {
  name: "RoutingTable",
  components: {RoutingTableRow},
  data() {
    return {
      query: this.$route.query,
      items: [],
      depart: null,
      arrive: null
    }
  },
  created: function () {
    this.$http.get('/station/stationById/' + this.query.departId)
        .then((response) => { this.depart = response.data[0] })
    this.$http.get('/station/stationById/' + this.query.arriveId)
        .then((response) => { this.arrive = response.data[0] })
    this.$http.get('/voyage/voyages/' + this.query.departId + "/" + this.query.arriveId + "/" + this.query.date)
        .then((response) => { this.items = response.data })
  }
}
</script>
