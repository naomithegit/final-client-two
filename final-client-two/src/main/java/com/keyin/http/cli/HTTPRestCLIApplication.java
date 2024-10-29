
package com.keyin.http.cli;

////hello


import com.keyin.domain.Passenger;
import com.keyin.domain.City;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApplication {

    private RESTClient restClient;

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }

        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public String generatePassengerReport() {
        List<Passenger> passengers = getRestClient().getAllPassengers();

        StringBuilder report = new StringBuilder();

        for (Passenger passenger : passengers) {
            report.append(passenger.getFirstName());
            report.append(" - ");
            report.append(passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getId());

            if (passengers.indexOf(passenger) != (passengers.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }

    public  String generateListOfCitiesForSpecificPassenger(Long passengerID) {
        List<City> cities = getRestClient().getCitiesForPassenger(passengerID);

        StringBuffer report = new StringBuffer();

        for (City city : cities) {
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getState());

            if (cities.indexOf(city) != (cities.size() - 1)) {
                report.append(",");
            }
        }

        System.out.println(report.toString());

        return report.toString();
    }





    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        String serverURL = args[0];
        Long passengerID = Long.parseLong(args[1]);

        cliApp.generateListOfCitiesForSpecificPassenger(passengerID);

        if (serverURL != null && !serverURL.isEmpty()) {

            RESTClient restClient = new RESTClient();
            restClient.setServerURL(serverURL);

            cliApp.setRestClient(restClient);

            if (serverURL.contains("greeting")) {

            } else if (serverURL.contains("getCitiesForPassenger")) {

                cliApp.generateListOfCitiesForSpecificPassenger();
            } else {
                cliApp.generatePassengerReport();
            }
        }

    }
}
