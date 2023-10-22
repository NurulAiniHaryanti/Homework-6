/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swaglabs.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
         features = "src/test/java/swaglabs/cucumber/resource/features",
         glue = "swaglabs.cucumber.stepdef",
         plugin = {"html:target/HTML_report.html"}
)
public class runLogin {
    
}
