# Lendico Code Challenge
**Steps to clone**

```
mkdir lendico-challenge
cd lendico-challenge
git init
git clone https://github.com/sivasyam/lendico-code-challenge.git
cd lendico-challenge
```

**Import the project to IntelliJ (from existing sources)**
```
-> Select File -> New -> projects from existing sources

-> Select the project location from the explorer
```

**Import the project from Git**
```
-> select File -> New -> import projects from Version Control -> Git

-> Enter "git clone https://github.com/sivasyam/lendico-code-challenge.git" in URL section of Clone Repository window

-> Select Directory

-> Click on Clone (if you already connected to Git) or else Login to Git and follow the same
```

**To Run project IntelliJ**
```
go to src/main/java/de/lendico in IntelliJ and right click on Application.java and select Run 'Application.main()'
```

**To Run project Command line**
```
  $ mvn spring-boot:run
```
**EndPoint**: POST  http://localhost:8080/generate-plan

**Sample Request**
```
{
"loanAmount": "5000",
"nominalRate": "5.0",
"duration": 24,
"startDate": "2018-01-01T00:00:01Z"
}
```

**Sample Response**
```
[
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-01-09T00:00:00Z",
        "initialOutstandingPrincipal": "5000.0",
        "interest": "20.83",
        "principal": "198.53",
        "remainingOutstandingPrincipal": "4801.47"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-02-09T00:00:00Z",
        "initialOutstandingPrincipal": "4801.47",
        "interest": "20.01",
        "principal": "199.35",
        "remainingOutstandingPrincipal": "4602.12"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-03-09T00:00:00Z",
        "initialOutstandingPrincipal": "4602.12",
        "interest": "19.18",
        "principal": "200.18",
        "remainingOutstandingPrincipal": "4401.94"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-04-08T23:00:00Z",
        "initialOutstandingPrincipal": "4401.94",
        "interest": "18.34",
        "principal": "201.02",
        "remainingOutstandingPrincipal": "4200.92"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-05-08T23:00:00Z",
        "initialOutstandingPrincipal": "4200.92",
        "interest": "17.5",
        "principal": "201.86",
        "remainingOutstandingPrincipal": "3999.06"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-06-08T23:00:00Z",
        "initialOutstandingPrincipal": "3999.06",
        "interest": "16.66",
        "principal": "202.7",
        "remainingOutstandingPrincipal": "3796.36"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-07-08T23:00:00Z",
        "initialOutstandingPrincipal": "3796.36",
        "interest": "15.82",
        "principal": "203.54",
        "remainingOutstandingPrincipal": "3592.82"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-08-08T23:00:00Z",
        "initialOutstandingPrincipal": "3592.82",
        "interest": "14.97",
        "principal": "204.39",
        "remainingOutstandingPrincipal": "3388.43"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-09-08T23:00:00Z",
        "initialOutstandingPrincipal": "3388.43",
        "interest": "14.12",
        "principal": "205.24",
        "remainingOutstandingPrincipal": "3183.19"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2018-10-08T23:00:00Z",
        "initialOutstandingPrincipal": "3183.19",
        "interest": "13.26",
        "principal": "206.1",
        "remainingOutstandingPrincipal": "2977.09"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2018-11-09T00:00:00Z",
        "initialOutstandingPrincipal": "2977.09",
        "interest": "12.4",
        "principal": "206.95",
        "remainingOutstandingPrincipal": "2770.14"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2018-12-09T00:00:00Z",
        "initialOutstandingPrincipal": "2770.14",
        "interest": "11.54",
        "principal": "207.81",
        "remainingOutstandingPrincipal": "2562.33"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2019-01-09T00:00:00Z",
        "initialOutstandingPrincipal": "2562.33",
        "interest": "10.68",
        "principal": "208.67",
        "remainingOutstandingPrincipal": "2353.66"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-02-09T00:00:00Z",
        "initialOutstandingPrincipal": "2353.66",
        "interest": "9.81",
        "principal": "209.55",
        "remainingOutstandingPrincipal": "2144.11"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-03-09T00:00:00Z",
        "initialOutstandingPrincipal": "2144.11",
        "interest": "8.93",
        "principal": "210.43",
        "remainingOutstandingPrincipal": "1933.68"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2019-04-08T23:00:00Z",
        "initialOutstandingPrincipal": "1933.68",
        "interest": "8.06",
        "principal": "211.29",
        "remainingOutstandingPrincipal": "1722.39"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-05-08T23:00:00Z",
        "initialOutstandingPrincipal": "1722.39",
        "interest": "7.18",
        "principal": "212.18",
        "remainingOutstandingPrincipal": "1510.21"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2019-06-08T23:00:00Z",
        "initialOutstandingPrincipal": "1510.21",
        "interest": "6.29",
        "principal": "213.06",
        "remainingOutstandingPrincipal": "1297.15"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-07-08T23:00:00Z",
        "initialOutstandingPrincipal": "1297.15",
        "interest": "5.4",
        "principal": "213.96",
        "remainingOutstandingPrincipal": "1083.19"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2019-08-08T23:00:00Z",
        "initialOutstandingPrincipal": "1083.19",
        "interest": "4.51",
        "principal": "214.84",
        "remainingOutstandingPrincipal": "868.35"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2019-09-08T23:00:00Z",
        "initialOutstandingPrincipal": "868.35",
        "interest": "3.62",
        "principal": "215.73",
        "remainingOutstandingPrincipal": "652.62"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-10-08T23:00:00Z",
        "initialOutstandingPrincipal": "652.62",
        "interest": "2.72",
        "principal": "216.64",
        "remainingOutstandingPrincipal": "435.98"
    },
    {
        "borrowerPaymentAmount": "219.35",
        "date": "2019-11-09T00:00:00Z",
        "initialOutstandingPrincipal": "435.98",
        "interest": "1.82",
        "principal": "217.53",
        "remainingOutstandingPrincipal": "218.45"
    },
    {
        "borrowerPaymentAmount": "219.36",
        "date": "2019-12-09T00:00:00Z",
        "initialOutstandingPrincipal": "218.45",
        "interest": "0.91",
        "principal": "218.45",
        "remainingOutstandingPrincipal": "0.0"
    }
]
```

I have created calculations for my best knowledge and tested with different amounts, also created Junit test cases (except integration test cases)

Note: I have considered input loan amount should be greater than 1000 in validation
