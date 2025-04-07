package com.monterio;

import com.monterio.business.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        CustomerManagerTest_Ex1.class,
        CustomerManagerTest_Ex2.class,
        CustomerManagerTest_Ex3.class,
        CustomerManagerTest_Ex4.class,
        CustomerManagerTest_Ex5.class,
        CustomerManagerTest_Ex7.class,
        CustomerManagerTest_Ex8.class,
        CustomerManagerTest_Ex10.class,

        CheckingAccountManagerTest_Ex3.class,
        CheckingAccountManagerTest_Ex4.class,
        CheckingAccountManagerTest_Ex6.class,
        CheckingAccountManagerTest_Ex11.class
})
public class AppTest {
}