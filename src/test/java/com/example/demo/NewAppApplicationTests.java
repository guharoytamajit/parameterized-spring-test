package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.example.demo.com.PrimeNumberChecker;

import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@ContextConfiguration(classes = {NewAppApplication.class})
public class NewAppApplicationTests {
   private Integer inputNumber;
   private Boolean expectedResult;
   
   
   @Autowired
   private PrimeNumberChecker primeNumberChecker;

   @ClassRule
   public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

   @Rule
   public final SpringMethodRule springMethodRule = new SpringMethodRule();
	
   public NewAppApplicationTests(Integer inputNumber, Boolean expectedResult) {
      this.inputNumber = inputNumber;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, true },
         { 6, true },
         { 19, true },
         { 22, false },
         { 23, true }
      });
   }

   // This test will run 4 times since we have 5 parameters defined
   @Test
   public void testPrimeNumberChecker() {
      System.out.println("Parameterized Number is : " + inputNumber);
      assertEquals("your input:"+inputNumber,expectedResult, 
      primeNumberChecker.validate(inputNumber));
   }
}