<template>
  <tr>
    <td>{{voyage.rout.depart.name}}<br>{{voyage.departDate}} {{voyage.departTime}}</td>
    <td>{{voyage.rout.arrive.name}}<br>{{voyage.arriveDate}} {{voyage.arriveTime}}</td>
    <td>{{voyage.name}}</td>
    <td>Плацкарт: {{voyage.rout.basePrice * voyage.train.economyMultiplierTop}}-{{voyage.rout.basePrice * voyage.train.economyMultiplierBot}} ₽<br>
<!--      Свободно: {{voyage.economyEmptySeats}}<br>-->
      Купе: {{voyage.rout.basePrice * voyage.train.coupMultiplierTop}}-{{voyage.rout.basePrice * voyage.train.coupMultiplierBot}} ₽<br>
<!--      Свободно: {{voyage.coupEmptySeats}}</td>-->
    <td>
      <router-link class="btn btn-danger btn-block" v-bind:to="{name: 'BuyTickets', query: {voyageId: voyage.id}}">Купить билеты</router-link>
    </td>
  </tr>
</template>

<script>
export default {
  name: "RoutingTableRow",
  props: ["voyage"]
}
</script>