package builder;

import petStore.order.request.PlacePetOrderRequest;

public class OrderBuilder {
    PlacePetOrderRequest placePetOrderRequest;
    public OrderBuilder(){
        placePetOrderRequest = new PlacePetOrderRequest();
        placePetOrderRequest.setId(-41439860);
        placePetOrderRequest.setPetId(-62735388);
        placePetOrderRequest.setQuantity(58604787);
        placePetOrderRequest.setShipDate("1960-12-19T22:58:12.664+0000");
        placePetOrderRequest.setStatus("placed");
        placePetOrderRequest.setComplete(true);

    }

    public PlacePetOrderRequest build() {
        return placePetOrderRequest;
    }
}
