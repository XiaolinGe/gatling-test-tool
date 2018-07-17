package com.anoyi.test

import java.util.concurrent.TimeUnit

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.{Duration, FiniteDuration}

class CollinsonRateTest extends Simulation {

  val scn: ScenarioBuilder = scenario("Rate")
    .repeat(1000, "n") {
    exec(
      http("Rare-API")
        .get("https://admin.collinsonfxtrader.com/api/v1/rate/real-time?token=eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJmeCIsInN1YiI6ImxlaS56aG91QGNmZ2dsb2JhbC5jby5ueiIsImlhdCI6MTUzMTY1MDAzMiwiZXhwIjoxNTMyNTE0MDMyfQ.vtqqqU0EPOKCuT5wPpUMbDSZ0VRcvvDBmR1ea9J7VuOEXGhxjIsyhA_xCq90JI27rkMiZUAFFKYqcmMFSCEtnQ")
        .header("Content-Type", "application/json")
        .check(status.is(200))
    ).pause(Duration.apply(1000, TimeUnit.MILLISECONDS))
  }

  setUp(scn.inject(atOnceUsers(20)))
    .maxDuration(FiniteDuration.apply(10, "minutes"))

}