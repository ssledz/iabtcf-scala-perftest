package io.github.ssledz

import java.util.concurrent.TimeUnit

import com.iabtcf.decoder.{TCString => JTCString}
import io.github.ssledz.TCStringParserBench._
import io.github.ssledz.iabtcf.TCString
import org.openjdk.jmh.annotations._

import scala.io.Source

@State(Scope.Thread)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Array(Mode.Throughput))
class TCStringParserBench {

  @Benchmark
  def iabTcfScalaBench: List[String] = {
    all.map { s =>
      val model = TCString.parse(s).core
      List(
        "vendor 123: " + model.vendorConsents.hasConsent(123),
        "vendor 13: " + model.vendorConsents.hasConsent(13)
      ).mkString("\n")
    }
  }

//  @Benchmark
//  def iabTcfJavaBench: List[String] = {
//    all.map { s =>
//      val model = JTCString.decode(s)
//      List(
//        "vendor 123: " + model.getVendorConsent.contains(123),
//        "vendor 13: " + model.getVendorConsent.contains(13)
//      ).mkString("\n")
//    }
//  }

}

object TCStringParserBench {

  val tcfs1 = Source.fromInputStream(classOf[TCStringParserBench].getClassLoader.getResourceAsStream("str-tcf-1.0.txt")).getLines.toList

  val tcfs2 = Source.fromInputStream(classOf[TCStringParserBench].getClassLoader.getResourceAsStream("str-tcf-2.0.txt")).getLines.toList

//  val all = List(tcfs1, tcfs2).flatten
  val all = List(tcfs2).flatten
//  val all = List(tcfs1).flatten

}