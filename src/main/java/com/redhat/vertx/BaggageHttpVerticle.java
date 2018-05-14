package com.redhat.vertx;


import java.util.ArrayList;
import java.util.List;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class BaggageHttpVerticle extends AbstractVerticle {

	private List<BaggageItem> baggages;
	private int maxBaggageId = 1;
    public BaggageHttpVerticle() {
		super();
		baggages = new ArrayList<BaggageItem>();
		
		BaggageItem baggageItem1 = new BaggageItem(""+maxBaggageId++, ""+100001, "40", "910", "EWR", "HKG", "01/01/2017 20.40", "CX");
		baggages.add(baggageItem1);
		
		BaggageItem baggageItem2 = new BaggageItem(""+maxBaggageId++, ""+100012, "30", "870", "SFO", "PVG", "11/01/2017 22.10", "CX");
		baggages.add(baggageItem2);
		
		BaggageItem baggageItem3 = new BaggageItem(""+maxBaggageId++, ""+100003, "32", "489", "LAX", "PEK", "01/01/2017 12.25", "CX");
		baggages.add(baggageItem3);
	}
	
    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.get("/baggage/intl/items").handler(this::baggage);
        
        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(8080);
    }

    private void baggage(RoutingContext rc) {

        JsonObject json = new JsonObject()
            .put("Baggage Items", baggages);
            
        rc.response()
            .putHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .end(json.encode());
    }
}


