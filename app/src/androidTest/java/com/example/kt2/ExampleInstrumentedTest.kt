package com.example.kt2

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testWaterButtonIncreasesCount() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // Проверяем начальное состояние (0 мл)
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        // Кликаем по кнопке увеличения воды
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").performClick()

        // Проверяем, что значение увеличилось до 250 мл
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()
    }

    @Test
    fun testFinishDayButtonResetsOrIncrementsStreak() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // Набираем меньше нормы (< 1500 мл), например, 3 раза по 250 = 750 мл
        val waterButton = composeTestRule.onNodeWithText("+250 мл")
        repeat(3) {
            waterButton.performClick()
        }

        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()

        // Нажимаем кнопку "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // Проверяем, что серия сбросилась в 0, а вода обнулилась
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Дней подряд с нормой: 0").assertIsDisplayed()
    }

    @Test
    fun testStreakIncreasesWhenGoalMet() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // Набираем норму: 1500 мл (6 кликов по 250 мл)
        val waterButton = composeTestRule.onNodeWithText("+250 мл")
        repeat(6) {
            waterButton.performClick()
        }

        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()

        // Нажимаем "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // Проверяем, что счетчик дней подряд увеличился до 1
        composeTestRule.onNodeWithText("Дней подряд с нормой: 1").assertIsDisplayed()
    }
}