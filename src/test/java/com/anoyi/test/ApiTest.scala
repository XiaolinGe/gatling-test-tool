package com.anoyi.test

import java.util.concurrent.TimeUnit

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.{Duration, FiniteDuration}

class ApiTest extends Simulation {

  val scn: ScenarioBuilder = scenario("Rate")
    .repeat(5, "n") {
    exec(
      http("Rare-API")
        .get("http://localhost:8080/product/buy2?id=1")
        .header("Content-Type", "application/json")
        .check(status.is(200))
    ).pause(Duration.apply(1000, TimeUnit.MILLISECONDS))
  }

  setUp(scn.inject(atOnceUsers(2)))
    .maxDuration(FiniteDuration.apply(5, "minutes"))

}