package com.eatsure.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import net.datafaker.Faker;

public class RandomDataGenerator {
	public String requesturlResponse;
	
	/**
	 * Description:- Generate Random Mobile no
	 * @return
	 * @author vivek ranjan
	 * @date 05-Apr-2024
	 */
	public static String generatePhoneNumber(){
		Faker faker = new Faker();
		return faker.number().digits(10);
		
	}
	/**
	 * Description:- Generate Random EmailID no
	 * @return
	 * @author vivek ranjan
	 * @date 05-Apr-2024
	 */
	public static String generateEmailId(){
		Faker faker = new Faker();
		return faker.name().firstName()+"@gmail.com";
		
	}
	
	/**
	 * Description:- Generate Random User Name no
	 * @return
	 * @author vivek ranjan
	 * @date 05-Apr-2024
	 */
	public static String generateName(){
		Faker faker = new Faker();
		return faker.name().firstName();
		
	}
	
	public synchronized String otp_api_call(String hiturl)  {
        String get_otp_api = hiturl;

        Response response = given().when().get(get_otp_api).then().extract().response();

        String otp_responseString = response.asString();

        JsonPath js = new JsonPath(otp_responseString);

        if (hiturl.contains("1111111112")) {
            int number_opt = js.getInt("otp");
            requesturlResponse = Integer.toString(number_opt);
            System.out.println("otp value-->" + requesturlResponse);

        } else {
            requesturlResponse = js.getString("message");
            System.out.println("Server response message" + requesturlResponse);

        }

        return requesturlResponse;
    }
	
}
