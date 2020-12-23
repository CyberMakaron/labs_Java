<template>
  <tr>
    <td>{{voyage.depart}}<br>{{voyage.departDateTime}}</td>
    <td>{{voyage.arrive}}<br>{{voyage.arriveDateTime}}</td>
    <td>{{voyage.name}}</td>
    <td>Плацкарт: {{voyage.economyPriceBot}}-{{voyage.economyPriceTop}} ₽<br>
      Свободно: {{voyage.economyEmptySeats}}<br>
      Купе: {{voyage.coupPriceBot}}-{{voyage.coupPriceTop}} ₽<br>
      Свободно: {{voyage.coupEmptySeats}}</td>
    <td>
      <button class="btn btn-danger btn-block btn-bot">Купить билеты</button>
    </td>
  </tr>
</template>

<script>
export default {
  name: "RoutingTableRow",
  props: ["voyage"],
  methods: {

  }
}
</script>