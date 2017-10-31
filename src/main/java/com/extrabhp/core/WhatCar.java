package com.extrabhp.core;

import com.extrabhp.exception.QuestionNotFoundException;
import com.extrabhp.model.Question.*;
import com.extrabhp.model.WhatCarModel;
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

    public static String noResults = "Sorry, I don't have answer for you right now! The website is still under development, your answers is logged and i'll try to find answer fot you ASAP, kindly try again later, Thanks!";

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
                                result.put("result", "Bear with me, since you're a stupid driver just get a `Tesla Model S` and stay a way from the high end performance models like P100D, so you don't kill anybody");
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

                    if(MoneyStatus.is(MoneyStatus.millionaire) || MoneyStatus.is(MoneyStatus.aLot)) {
                        if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                            result.put("result", "What about `Dodge Viper` or a `Dodge Challenger Hellcat` or `Ford Mustang GT500`");
                            return result;
                        }else if (GoodDriver.is(GoodDriver.modest)) {
                            result.put("result", "Bear with me, since you're a modest driver get a `Dodge Challenger` and stay a way from the high end performance models like `Hellcat`, so you don't kill anybody");
                            return result;
                        }else if(GoodDriver.is(GoodDriver.stupid)) {
                            result.put("result", "Bear with me, since you're a stupid driver get a `Dodge Challenger` and stay a way from the high end performance models like `Hellcat`, so you don't kill anybody");
                            return result;
                        }
                    }else if(MoneyStatus.is(MoneyStatus.enough)) {
                        if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                            result.put("result", "What about `Dodge Challenger SRT` or `Ford Mustang GT`");
                            return result;
                        }else if (GoodDriver.is(GoodDriver.modest)) {
                            result.put("result", "Bear with me, since you're a modest driver get a `Dodge Challenger` and stay a way from the high end performance models like `Hellcat`, so you don't kill anybody");
                            return result;
                        }else if(GoodDriver.is(GoodDriver.stupid)) {
                            result.put("result", "Bear with me, since you're a stupid driver get a `Dodge Challenger` and stay a way from the high end performance models like `Hellcat`, so you don't kill anybody");
                            return result;
                        }
                    }else if(MoneyStatus.is("broke")) {
                        result.put("result", "Broke!!! get a Ford Mustang (any old version if you can't afford a new one!)");
                    }

                }

            }else if(Petrolhead.is(Petrolhead.no) || Petrolhead.is(Petrolhead.what)) { // non-petrolhead

                if(MoneyStatus.is(MoneyStatus.millionaire)) {
                    if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                        if(LookingFor.is(LookingFor.beautiful)) {
                            result.put("result", "I'll recommend a super car, what about `Aston Martin Vanquish`");
                            return result;
                        }else if(LookingFor.is(LookingFor.luxury)) {
                            result.put("result", "Just Pick any `Rolls Royce` Or `Bentley Mulsanne`");
                            return result;
                        }else if(LookingFor.is(LookingFor.drivingExperience) || LookingFor.is(LookingFor.performance)) {
                            result.put("result", "I'll recommend a super car, what about `Lamborghini Huracan` or `Ferrari LaFerrari` or `Porsche 911 GT3`");
                            return result;
                        }else if(LookingFor.is(LookingFor.rare)) {
                            result.put("result", "I'll recommend a super car, what about `Ferrari LaFerrari`");
                            return result;
                        }else if(LookingFor.is(LookingFor.practical)) {
                            result.put("result", "Pick any 4 door `Rolls Royce` or `Bentley`, also some good options `Mercedes-Benz Maybach`, `Jaguar XJ`, `Porsche Panamera Turbo S`");
                            return result;
                        }
                    }else if (GoodDriver.is(GoodDriver.modest)) {
                        result.put("result", "Bear with me, I'll not recommend a super car for you cuz you're a modest driver, but here a good car for a millionaire what about `Nissan GTR Nismo`");
                        return result;
                    }else if(GoodDriver.is(GoodDriver.stupid)) {
                        result.put("result", "Bear with me, I'll not recommend a super car for you cuz you're a stupid driver, but here a good car for a millionaire what about `Nissan GTR Nismo`");
                        return result;
                    }
                }

                // environment_care
                if(EnvironmentCare.is(EnvironmentCare.aLot) || EnvironmentCare.is(EnvironmentCare.aLittle)) {

                    if (ElectricCar.is(ElectricCar.onlyElectric)) {
                        result.put("result", nonElectricOnly());
                        return result;
                    } else if (ElectricCar.is(ElectricCar.onlyFast)) {
                        if (MoneyStatus.is(MoneyStatus.millionaire)) {
                            if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                                result.put("result", "Get `Tesla Model S` a great car, and try to get the high end performance models like P100D");
                                return result;
                            } else if (GoodDriver.is(GoodDriver.modest)) {
                                result.put("result", "Bear with me, Since you're a modest driver get a `Tesla Model S` and stay a way from the high end performance models like P100D, so you don't kill anybody");
                                return result;
                            }
                        } else if (MoneyStatus.is(MoneyStatus.aLot)) {
                            if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                                result.put("result", "Get `Tesla Model S` a great car, and try to get the high end performance models like P100D");
                                return result;
                            }
                        }
                    }
                }

                if(MoneyStatus.is(MoneyStatus.aLot)) {
                    result.put("result", "What about `BMW M4` or Mercedes-AMG GT`");
                    return result;
                }else if(MoneyStatus.is(MoneyStatus.enough)) {
                    result.put("result", "What about `BMW 3 Series`");
                    return result;
                }else if(MoneyStatus.is("broke")) {
                    result.put("result", "What about `Ford Fiesta S Sedan`");
                    return result;
                }

//                // another_car
//                if(!answers.containsKey("another_car")) {
//                    result.put("next", "another_car");
//                    return result;
//                }

            }

        } catch (QuestionNotFoundException e) {
            return ask(e.getQuestionName());
        }

        result.put("result", noResult());
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

    private static String nonElectricOnly() throws QuestionNotFoundException {
        if(MoneyStatus.is(MoneyStatus.millionaire)) {
            if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                return  "Get `Tesla Model S` a great car, and try to get the high end performance models like P100D";
            }else if (GoodDriver.is(GoodDriver.modest)) {
                return  "Bear with me, Since you're a modest driver get a `Tesla Model S` and stay a way from the high end performance models like P100D, so you don't kill anybody";
            }else if(GoodDriver.is(GoodDriver.stupid)) {
                return  "Bear with me, Since you're a stupid driver get a `Tesla Model S` and stay a way from the high end performance models like P100D, so you don't kill anybody";
            }
        }else if(MoneyStatus.is(MoneyStatus.aLot)) {
            if (GoodDriver.is(GoodDriver.pro) || GoodDriver.is(GoodDriver.yes)) {
                return  "Get `Tesla Model S` a great car, and try to get the high end performance models like P100D";
            }else if (GoodDriver.is(GoodDriver.modest)) {
                return  "For a modest driver get `Tesla Model S` a great car and `Ford Focus Electric` is also an option";
            }else if(GoodDriver.is(GoodDriver.stupid)) {
                return  "Bear with me, Since you're a stupid driver just get a `Tesla Model S` and stay a way from the high end performance models like P100D, so you don't kill anybody";
            }
        }else if(MoneyStatus.is(MoneyStatus.enough)) {
            return "Get a `Tesla Model 3`, if you can't afford it then get a `Ford Focus Electric` or `Nissan LEAF`";
        }else if(MoneyStatus.is("broke")) {
            return "I know this hard, but since you'r broke just get a `Ford Focus Electric` or `Nissan LEAF`, if you still can't afford any of them then get any old petrol car man !!!!";
        }

        return noResult();
    }

    private static String noResult() {
        // TODO log the answers
        return noResults;
    }

}
