package com.extrabhp.core;

import com.extrabhp.exception.QuestionNotFoundException;
import com.extrabhp.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.core.MultivaluedMap;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * author Thaer Aldwaik <t_dwaik@hotmail.com>
 */
public class WhatCar {

    private static JSONObject questionsJson = null;

    public static MultivaluedMap<String, String> answers = null;

    public static Map<String, String> getNextQuestion(MultivaluedMap<String, String> answers) {

        WhatCar.answers = answers;

        Map<String, String> result = new HashMap<>();

        try {

            // stage 1
            boolean isPetrolhead = Petrolhead.is(Petrolhead.yes);

            // stage 2
            MoneyStatus.answer();

            // stage 3
            if(isPetrolhead) {

                if(WhatInMind.is(WhatInMind.hypercar)) {
                    if(MoneyStatus.is(MoneyStatus.millionaire)) {
                        result.put("result", "As Jeremy Clarkson once said \"Supercars are designed to be very, very fast, drivers cars above all. Hypercars are designed to show off, turn heads, and be as flamboyantly exotic as possible\". They are very very Rare, Fast, Luxurious cars, so if you're really looking for a Hypercar i'll not ask you anymore questions, I'll give you a shorten list of a Hypercars, you need to drive it and get to know the car soul first: Ferrari LaFerrari, McLaren P1, Porsche 918 Spyder, Bugatti Chiron, Bugatti Veyron, Lamborghini Aventador, Pagani Huayra, Aston Martin One-77, etc. Good Luck.");
                        return result;
                    }else {
                        result.put("result", "Ya, in your dreams!! Be a Millionaire first");
                        return result;
                    }
                }

                if(WhatInMind.is(WhatInMind.supercar)) {
                    if(MoneyStatus.is(MoneyStatus.millionaire) || MoneyStatus.is(MoneyStatus.aLot)) {

                        if(ElectricCar.is(ElectricCar.onlyElectric)) {
                            if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes) || GoodDriver.is(GoodDriver.modest)) {
                                result.put("result", "Get a Mercedes-Benz SLS AMG E-Cell Roadster, Epic.");
                            }else if(GoodDriver.is(GoodDriver.stupid)) {
                                result.put("result", "Bear with me, since you're a stupid driver just get a Tesla Model S and stay a way from the high end performance models like P100D, so you don't kill anybody");
                            }
                            return result;

                        }else {
                            String hybridCar = HybridCars.answer();

                            if(!hybridCar.equals(HybridCars.yesOnly)) {
                                String roadType = RoadType.answer();

                                String lookingFor = LookingFor.answer();
                            }

                            String inductionType = InductionType.answer();

                            String transmissionType = TransmissionType.answer();

                            String roadType = RoadType.answer();

                            String lookingFor = LookingFor.answer();

                        }

                    }else {
                        result.put("result", "Ya, in your dreams!! Get Some money first");
                        return result;
                    }
                }

                if(WhatInMind.is(WhatInMind.musclecar)) {

                    if(MoneyStatus.is(MoneyStatus.millionaire)) {

                        if(GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                            result.put("result", "Since you're a good driver, I think a Mercedes-Benz Electric SLS AMG is perfect, but you can also get the high end performance Tesla Model S P100D");
                        }else if(GoodDriver.is(GoodDriver.modest)) {
                            result.put("result", "Normally i'de recommend a Mercedes-Benz Electric SLS AMG, but since you're a modest driver stay a way from it and get the high end performance Tesla Model S P100D");
                        }else if(GoodDriver.is(GoodDriver.stupid)) {
                            result.put("result", "Bear with me, since you're a stupid driver just get a Tesla Model S and stay a way from the high end performance models like P100D, Or get a Tesla Model 3");
                        }
                        return result;

                    }else if(MoneyStatus.is("a-lot")) {

                        if(GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                            result.put("result", "Since you're a good driver, Get a Tesla Model S & try to get the high end P100D Model");
                        }else if(GoodDriver.is(GoodDriver.modest)) {
                            result.put("result", "Get a Tesla Model S, but since you're a modest driver try to stay a way from the high end performance models like P100D");
                        }else if(GoodDriver.is(GoodDriver.stupid)) {
                            result.put("result", "Bear with me, since you're a stupid driver just get a Tesla Model S and stay a way from the high end performance models like P100D so you don't kill anybody , Or Tesla Model 3");
                        }

                        return result;
                    }else {
                        result.put("result", "Ya, in your dreams!! Get Some Money first");
                        return result;
                    }
                }

                if(WhatInMind.is(WhatInMind.musclecar)) {
                    if(MoneyStatus.is("enough")) {
                        result.put("result", "Get a Tesla Model 3 or get Model S if you can afford it, if you can't afford any of them, then get a Ford Focus Electric! or Nissan LEAF!");
                        return result;
                    }else if(MoneyStatus.is("broke")) {
                        result.put("result", "I know this hard, but since you'r broke just get a Ford Focus Electric! or Nissan LEAF!, if you still can't afford any of them then get any old petrol car man !!!!");
                        return result;
                    }
                }

            }else if(Petrolhead.is(Petrolhead.no) || Petrolhead.is(Petrolhead.what)) { // non-petrolhead

                // environment_care
                if(EnvironmentCare.is(EnvironmentCare.aLot)) {

                    // another_car
                    if(!answers.containsKey("another_car")) {
                        result.put("next", "another_car");
                        return result;
                    }

                }else if(EnvironmentCare.is(EnvironmentCare.aLittle)) {

                    ElectricCar.answer();

                    // another_car
                    if(!answers.containsKey("another_car")) {
                        result.put("next", "another_car");
                        return result;
                    }

                }else if(EnvironmentCare.is(EnvironmentCare.no)) {

                }

            }

        } catch (QuestionNotFoundException e) {
            return ask(e.getQuestionName());
        }

        result.put("result", "Sorry, I don't have answer for you right now! The website is still under development, Kindly try again later. Thanks!");
        return result;
    }

    public static JSONObject getQuestion(String questionName) throws IOException, IllegalAccessException {

        if(questionsJson == null) {
            String questionsJsonFile = new String(Files.readAllBytes(Paths.get(App.PATH + "/WEB-INF/classes/questions.json")), StandardCharsets.UTF_8);
            questionsJson = new JSONObject(questionsJsonFile);
        }
//        String pageName = obj.getJSONObject("questions").getString(qName);

        JSONArray arr = questionsJson.getJSONArray("questions");
        for (int i = 0; i < arr.length(); i++) {
            if(arr.getJSONObject(i).getString("name").equals(questionName)) {
//                String question = arr.getJSONObject(i).getString("question");
//                System.out.println(question);
                return arr.getJSONObject(i);
            }
        }

        return null;
    }

    public static Map<String, String> ask(String questionName) {
        Map<String, String> result = new HashMap<>();
        result.put("next", questionName);
        return result;
    }

}
