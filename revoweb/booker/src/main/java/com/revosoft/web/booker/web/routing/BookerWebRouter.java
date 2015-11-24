package com.revosoft.web.booker.web.routing;

import com.revosoft.netty.server.Values;
import com.revosoft.netty.server.http.routing.WebRouter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class BookerWebRouter implements WebRouter {

    public Object routeRequest (String uri, Values values) {

        if(uri.equals("/revoweb/booker")) {
            return "{\n\r" +
                    "                    name: \\\"Kingscross\\\",\n\r" +
                    "                    address1: \\\"8 York Road\\\",\n" +
                    "                    address2: \\\"Kingscross\\\",\n" +
                    "                    TownCity: \\\"London\\\",\n" +
                    "                    postcode: \\\"SE280GF\\\",\n" +
                    "                    longitude: \\\"000\\\",\n" +
                    "                    latitude: \\\"000\\\",\n" +
                    "                    currency: \\\"£\\\",\n" +
                    "                    accepted_payment_types: [0, 1, 2, 3],\n" +
                    "            staff: [{name: \\\"Daniele\\\", email: \\\"daniele.perseguine@revowax.com\\\"},\n" +
                    "            {name: \\\"Phil\\\", email: \\\"phil.day@revowax.com\\\"},\n" +
                    "            {name: \\\"Derek\\\", email: \\\"derek.bryan@revowax.com\\\"},\n" +
                    "            {name: \\\"Katie\\\", email: \\\"katie@revowax.com\\\"},\n" +
                    "            {name: \\\"Tuca\\\", email: \\\"tuca@revowax.com\\\"},\n" +
                    "            ],\n" +
                    "            opening_times: {\n" +
                    "                monday: \\\"11:00am\\\",\n" +
                    "                        tuesdday: \\\"11:00am\\\",\n" +
                    "                        wednesday: \\\"11:00am\\\",\n" +
                    "                        thursday: \\\"11:00am\\\",\n" +
                    "                        friday: \\\"11:00am\\\",\n" +
                    "                        saturday: \\\"11:00am\\\",\n" +
                    "                        sunday: \\\"Closed\\\",\n" +
                    "            },\n" +
                    "            closing_times: {\n" +
                    "                monday: \\\"8:00pm\\\",\n" +
                    "                        tuesdday: \\\"8:00pm\\\",\n" +
                    "                        wednesday: \\\"8:00pm\\\",\n" +
                    "                        thursday: \\\"8:00pm\\\",\n" +
                    "                        friday: \\\"8:00pm\\\",\n" +
                    "                        saturday: \\\"8:00pm\\\",\n" +
                    "                        sunday: \\\"Closed\\\",\n" +
                    "            },\n" +
                    "            // Categories of services\n" +
                    "            categories: [\n" +
                    "            {\n" +
                    "                name: \\\"For Her\\\",\n" +
                    "                        subcategories: [\n" +
                    "                {\n" +
                    "                    name: \\\"Intimate\\\",\n" +
                    "                            services: [\n" +
                    "                    {name: \\\"Hollywood\\\", duration: \\\"20\\\", price: \\\"40\\\"},\n" +
                    "                    {name: \\\"Brazilian\\\", duration: \\\"20\\\", price: \\\"35\\\"},\n" +
                    "                    {name: \\\"Bikini Line\\\", duration: \\\"20\\\", price: \\\"18\\\"},\n" +
                    "                    {name: \\\"Bikini Extended\\\", duration: \\\"20\\\", price: \\\"24\\\"},\n" +
                    "                    {name: \\\"Bottom Inside\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Bottom Outside\\\", duration: \\\"20\\\", price: \\\"15\\\"},\n" +
                    "                    {name: \\\"Full Bottom\\\", duration: \\\"20\\\", price: \\\"25\\\"},\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    name: \\\"Body\\\",\n" +
                    "                            services: [\n" +
                    "                    {name: \\\"Half Arms\\\", duration: \\\"20\\\", price: \\\"20\\\"},\n" +
                    "                    {name: \\\"Arms\\\", duration: \\\"30\\\", price: \\\"27\\\"},\n" +
                    "                    {name: \\\"Under Arm\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Full Belly\\\", duration: \\\"10\\\", price: \\\"15\\\"},\n" +
                    "                    {name: \\\"Lower Belly\\\", duration: \\\"10\\\", price: \\\"3\\\"},\n" +
                    "                    {name: \\\"Lower Leg\\\", duration: \\\"20\\\", price: \\\"20\\\"},\n" +
                    "                    {name: \\\"Upper Leg\\\", duration: \\\"30\\\", price: \\\"22\\\"},\n" +
                    "                    {name: \\\"Full Leg\\\", duration: \\\"40\\\", price: \\\"40\\\"},\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    name: \\\"Face\\\",\n" +
                    "                            services: [\n" +
                    "                    {name: \\\"Upper Lip\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Eyebrows\\\", duration: \\\"20\\\", price: \\\"13\\\"},\n" +
                    "                    {name: \\\"Side Burns\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Chin\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Chin Upper Lip\\\", duration: \\\"20\\\", price: \\\"15\\\"},\n" +
                    "                    {name: \\\"Face (Each Part)\\\", duration: \\\"10\\\", price: \\\"5\\\"},\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    name: \\\"Combinations\\\",\n" +
                    "                            services: [\n" +
                    "                    {name: \\\"Lower Leg + Hollywood\\\", duration: \\\"40\\\", price: \\\"51\\\"},\n" +
                    "                    {name: \\\"Lower Leg + Brazilian\\\", duration: \\\"40\\\", price: \\\"46\\\"},\n" +
                    "                    {name: \\\"Lower Leg + Bikini Line\\\", duration: \\\"40\\\", price: \\\"31\\\"},\n" +
                    "                    {name: \\\"Lower Leg + Bikini Extended\\\", duration: \\\"40\\\", price: \\\"36\\\"},\n" +
                    "                    {name: \\\"Upper Leg + Hollywood\\\", duration: \\\"40\\\", price: \\\"54\\\"},\n" +
                    "                    {name: \\\"Upper Leg + Brazilian\\\", duration: \\\"40\\\", price: \\\"50\\\"},\n" +
                    "                    {name: \\\"Upper Leg + Bikini Line\\\", duration: \\\"40\\\", price: \\\"34\\\"},\n" +
                    "                    {name: \\\"Upper Leg + Bikini Extended\\\", duration: \\\"40\\\", price: \\\"34\\\"},\n" +
                    "                    {name: \\\"Leg + Hollywood\\\", duration: \\\"60\\\", price: \\\"60\\\"},\n" +
                    "                    {name: \\\"Leg + Brazilian\\\", duration: \\\"60\\\", price: \\\"55\\\"},\n" +
                    "                    {name: \\\"Leg + Bikini Line\\\", duration: \\\"50\\\", price: \\\"43\\\"},\n" +
                    "                    {name: \\\"Leg + Bikini Extended\\\", duration: \\\"50\\\", price: \\\"48\\\"},\n" +
                    "                    ]\n" +
                    "                }\n" +
                    "                ]\n" +
                    "            },\n" +
                    "            {\n" +
                    "                name: \\\"For Him\\\",\n" +
                    "                        subcategories:\n" +
                    "                [\n" +
                    "                {\n" +
                    "                    name: \\\"Face\\\",\n" +
                    "                            services: [\n" +
                    "                    {name: \\\"Beard\\\", duration: \\\"30\\\", price: \\\"30\\\"},\n" +
                    "                    {name: \\\"Ears\\\", duration: \\\"10\\\", price: \\\"7\\\"},\n" +
                    "                    {name: \\\"Nose\\\", duration: \\\"10\\\", price: \\\"7\\\"},\n" +
                    "                    {name: \\\"Face Parts\\\", duration: \\\"10\\\", price: \\\"7\\\"},\n" +
                    "                    {name: \\\"Eye Brows\\\", duration: \\\"10\\\", price: \\\"13\\\"},\n" +
                    "                    ]\n" +
                    "                },\n" +
                    "                {\n" +
                    "                    name: \\\"Body\\\",\n" +
                    "                            services: [\n" +
                    "                    {name: \\\"Full Back\\\", duration: \\\"40\\\", price: \\\"40\\\"},\n" +
                    "                    {name: \\\"Full Front\\\", duration: \\\"40\\\", price: \\\"40\\\"},\n" +
                    "                    {name: \\\"Shoulders\\\", duration: \\\"20\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Chest\\\", duration: \\\"20\\\", price: \\\"23\\\"},\n" +
                    "                    {name: \\\"Stomach\\\", duration: \\\"20\\\", price: \\\"20\\\"},\n" +
                    "                    {name: \\\"Neck\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Back Neck\\\", duration: \\\"10\\\", price: \\\"10\\\"},\n" +
                    "                    {name: \\\"Arms\\\", duration: \\\"40\\\", price: \\\"45\\\"},\n" +
                    "                    {name: \\\"Under Arms\\\", duration: \\\"10\\\", price: \\\"12\\\"},\n" +
                    "                    {name: \\\"Hands\\\", duration: \\\"10\\\", price: \\\"8\\\"},\n" +
                    "                    {name: \\\"Legs\\\", duration: \\\"60\\\", price: \\\"70\\\"},\n" +
                    "                    ]\n" +
                    "                }\n" +
                    "                ]\n" +
                    "            },\n" +
                    "      ],\n" +
                    "};";
        }

        return "No Services for this URI";
    }

    public String toString() {
        return "BookerRouter";
    }

}
