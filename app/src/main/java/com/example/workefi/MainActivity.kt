package com.example.workefi

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        val drinking_water = findViewById<CardView>(R.id.DrinkingWaterMainButton)
        val pomodoro_technique = findViewById<CardView>(R.id.PomodoroTechniqueMainButton)
        val _20_20_20_rule = findViewById<CardView>(R.id._20_20_20_RuleMainButton)


        val dw_ft = findViewById<CardView>(R.id.DrinkingWaterFocusTime)
        val pt_ft = findViewById<CardView>(R.id.PomodoroTechniqueFocusTime)
        val tt_ft = findViewById<CardView>(R.id._20_20_20_RuleFocusTime)

        val dw_ft_hour_data = findViewById<TextView>(R.id.DrinkingWaterFocusTimeHourData)
        val pt_ft_hour_data = findViewById<TextView>(R.id.PomodoroTechniqueFocusTimeHourData)
        val tt_ft_hour_data = findViewById<TextView>(R.id._20_20_20_RuleFocusTimeHourData)

        val dw_ft_minutes_data = findViewById<TextView>(R.id.DrinkingWaterFocusTimeMinutesData)
        val pt_ft_minutes_data = findViewById<TextView>(R.id.PomodoroTechniqueFocusTimeMinutesData)
        val tt_ft_minutes_data = findViewById<TextView>(R.id._20_20_20_RuleFocusTimeMinutesData)

        val dw_ft_hour_data_dc =
            findViewById<ImageView>(R.id.DrinkingWaterFocusTimeHourDataDecrement)
        val pt_ft_hour_data_dc =
            findViewById<ImageView>(R.id.PomodoroTechniqueFocusTimeHourDataDecrement)
        val tt_ft_hour_data_dc =
            findViewById<ImageView>(R.id._20_20_20_RuleFocusTimeHourDataDecrement)
        val dw_ft_hour_data_ic =
            findViewById<ImageView>(R.id.DrinkingWaterFocusTimeHourDataIncrement)
        val pt_ft_hour_data_ic =
            findViewById<ImageView>(R.id.PomodoroTechniqueFocusTimeHourDataIncrement)
        val tt_ft_hour_data_ic =
            findViewById<ImageView>(R.id._20_20_20_RuleFocusTimeHourDataIncrement)

        val dw_ft_minutes_data_dc =
            findViewById<ImageView>(R.id.DrinkingWaterFocusTimeMinutesDataDecrement)
        val pt_ft_minutes_data_dc =
            findViewById<ImageView>(R.id.PomodoroTechniqueFocusTimeMinutesDataDecrement)
        val tt_ft_minutes_data_dc =
            findViewById<ImageView>(R.id._20_20_20_RuleFocusTimeMinutesDataDecrement)
        val dw_ft_minutes_data_ic =
            findViewById<ImageView>(R.id.DrinkingWaterFocusTimeMinutesDataIncrement)
        val pt_ft_minutes_data_ic =
            findViewById<ImageView>(R.id.PomodoroTechniqueFocusTimeMinutesDataIncrement)
        val tt_ft_minutes_data_ic =
            findViewById<ImageView>(R.id._20_20_20_RuleFocusTimeMinutesDataIncrement)


        val dw_I = findViewById<CardView>(R.id.DrinkingWaterInterval)
        val pt_I = findViewById<CardView>(R.id.PomodoroTechniqueInterval)
        val tt_I = findViewById<CardView>(R.id._20_20_20_RuleInterval)

        val dw_I_hour_data = findViewById<TextView>(R.id.DrinkingWaterIntervalHourData)
        val pt_I_hour_data = findViewById<TextView>(R.id.PomodoroTechniqueIntervalHourData)
        val tt_I_hour_data = findViewById<TextView>(R.id._20_20_20_RuleIntervalHourData)

        val dw_I_minutes_data = findViewById<TextView>(R.id.DrinkingWaterIntervalMinutesData)
        val pt_I_minutes_data = findViewById<TextView>(R.id.PomodoroTechniqueIntervalMinutesData)
        val tt_I_minutes_data = findViewById<TextView>(R.id._20_20_20_RuleIntervalMinutesData)

        val dw_I_hour_data_dc = findViewById<ImageView>(R.id.DrinkingWaterIntervalHourDataDecrement)
        val pt_I_hour_data_dc =
            findViewById<ImageView>(R.id.PomodoroTechniqueIntervalHourDataDecrement)
        val tt_I_hour_data_dc =
            findViewById<ImageView>(R.id._20_20_20_RuleIntervalHourDataDecrement)
        val dw_I_hour_data_ic = findViewById<ImageView>(R.id.DrinkingWaterIntervalHourDataIncrement)
        val pt_I_hour_data_ic =
            findViewById<ImageView>(R.id.PomodoroTechniqueIntervalHourDataIncrement)
        val tt_I_hour_data_ic =
            findViewById<ImageView>(R.id._20_20_20_RuleIntervalHourDataIncrement)

        val dw_I_minutes_data_dc =
            findViewById<ImageView>(R.id.DrinkingWaterIntervalMinutesDataDecrement)
        val pt_I_minutes_data_dc =
            findViewById<ImageView>(R.id.PomodoroTechniqueIntervalMinutesDataDecrement)
        val tt_I_minutes_data_dc =
            findViewById<ImageView>(R.id._20_20_20_RuleIntervalMinutesDataDecrement)
        val dw_I_minutes_data_ic =
            findViewById<ImageView>(R.id.DrinkingWaterIntervalMinutesDataIncrement)
        val pt_I_minutes_data_ic =
            findViewById<ImageView>(R.id.PomodoroTechniqueIntervalMinutesDataIncrement)
        val tt_I_minutes_data_ic =
            findViewById<ImageView>(R.id._20_20_20_RuleIntervalMinutesDataIncrement)

        val dw_RT_button = findViewById<ImageView>(R.id.DrinkingWaterReminderTimeButton)
        val dw_RT_data = findViewById<TextView>(R.id.DrinkingWaterReminderTime)

        val pt_RT_button = findViewById<ImageView>(R.id.PomodoroTechniqueReminderTimeButton)
        val pt_RT_data = findViewById<TextView>(R.id.PomodoroTechniqueReminderTime)

        val tt_RT_button = findViewById<ImageView>(R.id._20_20_20_RuleReminderTimeButton)
        val tt_RT_data = findViewById<TextView>(R.id._20_20_20_RuleReminderTime)

        val dw_start = findViewById<Button>(R.id.DrinkingWaterStart)
        val pt_start = findViewById<Button>(R.id.PomodoroTechniqueStart)
        val tt_start = findViewById<Button>(R.id._20_20_20_RuleStart)


        val selectedColor = ContextCompat.getColorStateList(this, R.color.selectedColor)
        val nonSelectedColor = ContextCompat.getColorStateList(this, R.color.nonSelectedColor)

        var drinkingWaterFocusTimeHourData: Int = 4
        var drinkingWaterFocusTimeHourDataString: String
        var drinkingWaterFocusTimeMinutesData: Int = 30
        var drinkingWaterFocusTimeMinutesDataString: String
        var drinkingWaterIntervalHourData: Int = 2
        var drinkingWaterIntervalHourDataString: String
        var drinkingWaterIntervalMinutesData: Int = 30
        var drinkingWaterIntervalMinutesDataString: String
        var drinkingWaterReminderTime : Int = 2
        var drinkingWaterReminderTimeString : String

        var DWtotalFocusTimeMinutes : Int
        var DWtotalIntervalMinutes : Int


        var pomodoroTechniqueFocusTimeHourData: Int = 2
        var pomodoroTechniqueFocusTimeHourDataString: String
        var pomodoroTechniqueFocusTimeMinutesData: Int = 30
        var pomodoroTechniqueFocusTimeMinutesDataString: String
        var pomodoroTechniqueIntervalHourData: Int = 2
        var pomodoroTechniqueIntervalHourDataString: String
        var pomodoroTechniqueIntervalMinutesData: Int = 30
        var pomodoroTechniqueIntervalMinutesDataString: String
        var pomodoroTechniqueReminderTime : Int = 5
        var pomodoroTechniqueReminderTimeString : String

        var PTtotalFocusTimeMinutes : Int
        var PTtotalIntervalMinutes : Int


        var twentyTwentyRuleFocusTimeHourData: Int = 2
        var twentyTwentyRuleFocusTimeHourDataString: String
        var twentyTwentyRuleFocusTimeMinutesData: Int = 30
        var twentyTwentyRuleFocusTimeMinutesDataString: String
        var twentyTwentyRuleIntervalHourData: Int = 2
        var twentyTwentyRuleIntervalHourDataString: String
        var twentyTwentyRuleIntervalMinutesData: Int = 30
        var twentyTwentyRuleIntervalMinutesDataString: String
        var twentyTwentyRuleReminderTime : Int = 20
        var twentyTwentyRuleReminderTimeString : String

        var TTTtotalFocusTimeMinutes : Int
        var TTTtotalIntervalMinutes : Int





        drinking_water.setOnClickListener {
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            } else {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
            }
        }

        dw_ft_hour_data_ic.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                if (drinkingWaterFocusTimeHourData < 24){
                    drinkingWaterFocusTimeHourData+=1
                    drinkingWaterFocusTimeHourDataString = drinkingWaterFocusTimeHourData.toString()
                    dw_ft_hour_data.text = drinkingWaterFocusTimeHourDataString
                }
                else {
                    drinkingWaterFocusTimeHourData = 0
                    drinkingWaterFocusTimeHourDataString = drinkingWaterFocusTimeHourData.toString()
                    dw_ft_hour_data.text = drinkingWaterFocusTimeHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        dw_ft_hour_data_dc.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                if (drinkingWaterFocusTimeHourData > 0){
                    if(drinkingWaterFocusTimeHourData>drinkingWaterIntervalHourData){
                        drinkingWaterFocusTimeHourData-=1
                        drinkingWaterFocusTimeHourDataString = drinkingWaterFocusTimeHourData.toString()
                        dw_ft_hour_data.text = drinkingWaterFocusTimeHourDataString
                    }
                    else{
                        val toast = Toast.makeText(this, "Focus Time Could Not be Less then Interval Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }
                else{
                    drinkingWaterFocusTimeHourData = 24
                    drinkingWaterFocusTimeHourDataString = drinkingWaterFocusTimeHourData.toString()
                    dw_ft_hour_data.text = drinkingWaterFocusTimeHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        dw_ft_minutes_data_ic.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                if (drinkingWaterFocusTimeMinutesData < 60){
                    drinkingWaterFocusTimeMinutesData+=5
                    drinkingWaterFocusTimeMinutesDataString = drinkingWaterFocusTimeMinutesData.toString()
                    dw_ft_minutes_data.text = drinkingWaterFocusTimeMinutesDataString
                }
                else {
                    drinkingWaterFocusTimeMinutesData = 0
                    drinkingWaterFocusTimeMinutesDataString = drinkingWaterFocusTimeMinutesData.toString()
                    dw_ft_minutes_data.text = drinkingWaterFocusTimeMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        dw_ft_minutes_data_dc.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                DWtotalFocusTimeMinutes = drinkingWaterFocusTimeHourData*60+drinkingWaterFocusTimeMinutesData
                DWtotalIntervalMinutes = drinkingWaterIntervalHourData*60+drinkingWaterIntervalMinutesData
                if (drinkingWaterFocusTimeMinutesData > 0){
                    if(DWtotalIntervalMinutes<DWtotalFocusTimeMinutes){
                        drinkingWaterFocusTimeMinutesData-=5
                        drinkingWaterFocusTimeMinutesDataString = drinkingWaterFocusTimeMinutesData.toString()
                        dw_ft_minutes_data.text = drinkingWaterFocusTimeMinutesDataString
                        DWtotalFocusTimeMinutes = drinkingWaterFocusTimeHourData*60+drinkingWaterFocusTimeMinutesData
                        DWtotalIntervalMinutes = drinkingWaterIntervalHourData*60+drinkingWaterIntervalMinutesData
                    }
                    else{
                        val toast = Toast.makeText(this, "Focus Time Could Not be Less then Interval Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }
                else{
                    drinkingWaterFocusTimeHourData-=1
                    drinkingWaterFocusTimeHourDataString = drinkingWaterFocusTimeHourData.toString()
                    dw_ft_hour_data.text = drinkingWaterFocusTimeHourDataString

                    drinkingWaterFocusTimeMinutesData = 60
                    drinkingWaterFocusTimeMinutesDataString = drinkingWaterFocusTimeMinutesData.toString()
                    dw_ft_minutes_data.text = drinkingWaterFocusTimeMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        dw_I_hour_data_ic.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                if (drinkingWaterIntervalHourData < 24 && drinkingWaterIntervalHourData<drinkingWaterFocusTimeHourData){
                    drinkingWaterIntervalHourData+=1
                    drinkingWaterIntervalHourDataString = drinkingWaterIntervalHourData.toString()
                    dw_I_hour_data.text = drinkingWaterIntervalHourDataString
                }
                else {
                    val toast = Toast.makeText(this, "Interval Time Could Not be Greater then Focus Time", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        dw_I_hour_data_dc.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                if (drinkingWaterIntervalHourData > 0){
                    drinkingWaterIntervalHourData-=1
                    drinkingWaterIntervalHourDataString = drinkingWaterIntervalHourData.toString()
                    dw_I_hour_data.text = drinkingWaterIntervalHourDataString
                }
                else{
                    drinkingWaterIntervalHourData = drinkingWaterFocusTimeHourData
                    drinkingWaterIntervalHourDataString = drinkingWaterIntervalHourData.toString()
                    dw_I_hour_data.text = drinkingWaterIntervalHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        dw_I_minutes_data_ic.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                DWtotalFocusTimeMinutes = drinkingWaterFocusTimeHourData*60+drinkingWaterFocusTimeMinutesData
                DWtotalIntervalMinutes = drinkingWaterIntervalHourData*60+drinkingWaterIntervalMinutesData

                if (drinkingWaterIntervalMinutesData < 59){
                    if(DWtotalIntervalMinutes<DWtotalFocusTimeMinutes){
                        drinkingWaterIntervalMinutesData+=5
                        drinkingWaterIntervalMinutesDataString = drinkingWaterIntervalMinutesData.toString()
                        dw_I_minutes_data.text = drinkingWaterIntervalMinutesDataString
                        DWtotalFocusTimeMinutes = drinkingWaterFocusTimeHourData*60+drinkingWaterFocusTimeMinutesData
                        DWtotalIntervalMinutes = drinkingWaterIntervalHourData*60+drinkingWaterIntervalMinutesData
                    }
                    else {
                        val toast = Toast.makeText(this, "Interval Time Could Not be Greater then Focus Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }
                else{
                    drinkingWaterIntervalHourData+=1
                    drinkingWaterIntervalHourDataString = drinkingWaterIntervalHourData.toString()
                    dw_I_hour_data.text = drinkingWaterIntervalHourDataString

                    drinkingWaterIntervalMinutesData = 0
                    drinkingWaterIntervalMinutesDataString = drinkingWaterIntervalMinutesData.toString()
                    dw_I_minutes_data.text = drinkingWaterIntervalMinutesDataString
                }

            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        dw_I_minutes_data_dc.setOnClickListener{
            if (drinking_water.cardBackgroundColor == nonSelectedColor) {
                drinking_water.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                dw_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                if (drinkingWaterIntervalMinutesData > 0){
                    drinkingWaterIntervalMinutesData-=5
                    drinkingWaterIntervalMinutesDataString = drinkingWaterIntervalMinutesData.toString()
                    dw_I_minutes_data.text = drinkingWaterIntervalMinutesDataString
                }
                else{
                    drinkingWaterIntervalHourData-=1
                    drinkingWaterIntervalHourDataString = drinkingWaterIntervalHourData.toString()
                    dw_I_hour_data.text = drinkingWaterIntervalHourDataString

                    drinkingWaterIntervalMinutesData = 60
                    drinkingWaterIntervalMinutesDataString = drinkingWaterIntervalMinutesData.toString()
                    dw_I_minutes_data.text = drinkingWaterIntervalMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Drinking Water Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        dw_RT_button.setOnClickListener{
            if(drinkingWaterReminderTime < 5){
                drinkingWaterReminderTime++
                drinkingWaterReminderTimeString = drinkingWaterReminderTime.toString()
                dw_RT_data.text = drinkingWaterReminderTimeString
            }
            else if(drinkingWaterReminderTime in 5..29){
                drinkingWaterReminderTime += 5
                drinkingWaterReminderTimeString = drinkingWaterReminderTime.toString()
                dw_RT_data.text = drinkingWaterReminderTimeString
            }
            else if(drinkingWaterReminderTime == 30) {
                drinkingWaterReminderTime = 1
                drinkingWaterReminderTimeString = drinkingWaterReminderTime.toString()
                dw_RT_data.text = drinkingWaterReminderTimeString
            }
        }
        createNotificationChannel()
        dw_start.setOnClickListener{
            val intent = Intent(this, DrinkingWaterReceiver::class.java)
            val pendingintent = PendingIntent.getBroadcast(this, 6969, intent, PendingIntent.FLAG_IMMUTABLE)

            var currentTime = 0L
            val interval = 10000L
            val endTime = 60000L

            val handler = Handler()

            val alarmRunnable = object : Runnable {
                override fun run() {
                    while(currentTime <= endTime) {
                        alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + currentTime, pendingintent)
                        currentTime += interval
                        handler.postDelayed(this, interval)
                    }
                }
            }

            handler.post(alarmRunnable)

            val toast = Toast.makeText(this, "You will be reminded every 10 seconds to drink water for 1 minute", Toast.LENGTH_SHORT)
            toast.show()
        }


/*
        dw_start.setOnClickListener {
            val intent = Intent(this, DrinkingWaterReceiver::class.java)
            val pendingintent = PendingIntent.getBroadcast(this, 1111, intent, PendingIntent.FLAG_IMMUTABLE)

            fun setNextAlarm(currentTime: Long) {
                if (currentTime < 60000) {
                    alarmManager.set(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + currentTime,
                        pendingintent
                    )
                    setNextAlarm(currentTime + 10000)
                }
            }

            setNextAlarm(0)

            val toast = Toast.makeText(
                this,
                "You will be reminded every 10 seconds to drink water for 1 minute",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }



        dw_start.setOnClickListener{
            val triggeredTime : Long = 10000
            val focusTime = 50000

            val startTime = System.currentTimeMillis()
            val endTime = startTime + focusTime

            val intent = Intent(this, DrinkingWaterReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 1111, intent, PendingIntent.FLAG_IMMUTABLE)

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggeredTime, triggeredTime, pendingIntent)

            // schedule a PendingIntent to cancel the repeating PendingIntent
            val cancelIntent = Intent(this, DrinkingWaterReceiver::class.java)
            val cancelPendingIntent = PendingIntent.getBroadcast(this, 2222, cancelIntent, PendingIntent.FLAG_IMMUTABLE)
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, endTime, cancelPendingIntent)

            val toast = Toast.makeText(this, "You will be reminded after $drinkingWaterIntervalHourData hours & $drinkingWaterIntervalMinutesData minutes", Toast.LENGTH_SHORT)
            toast.show()
        }

   *///val triggeredTime = System.currentTimeMillis()+(((drinkingWaterIntervalHourData*60)+drinkingWaterIntervalMinutesData)*60*1000)
        //val triggeredTime = System.currentTimeMillis()+10000
        //val focusTime = System.currentTimeMillis()+50000
        //alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pendingintent)
        /*dw_start.setOnClickListener{
            val intent = Intent(this, DrinkingWaterReceiver::class.java)
            val pendingintent = PendingIntent.getBroadcast(this ,1111,intent, PendingIntent.FLAG_IMMUTABLE)

            var currentTime =  0
            while (currentTime < 60000) {
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+currentTime,pendingintent)
                currentTime += 10000
            }

            val toast = Toast.makeText(this, "You Will be reminder after $drinkingWaterIntervalHourData hours & $drinkingWaterIntervalMinutesData minutes", Toast.LENGTH_SHORT)
            toast.show()
        }

         */
/*
        dw_start.setOnClickListener{
            //val intervalMillis = (drinkingWaterIntervalHourData * 60 + drinkingWaterIntervalMinutesData) * 60 * 1000 // interval in milliseconds
            val triggeredTime :Long = 20000
            val focusTime:Long = 100000

            val startTime:Long = System.currentTimeMillis()
            val endTime:Long = startTime + focusTime

            val intent = Intent(this, DrinkingWaterReceiver::class.java)
            val pendingintent = PendingIntent.getBroadcast(this, 1111, intent, PendingIntent.FLAG_IMMUTABLE)

            // Schedule repeating alarms at fixed interval until end time
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, startTime + triggeredTime,triggeredTime, pendingintent)
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, endTime, pendingintent)

            val toast = Toast.makeText(this, "You will be reminded every $drinkingWaterIntervalHourData hour(s) and $drinkingWaterIntervalMinutesData minute(s) until $endTime", Toast.LENGTH_SHORT)
            toast.show()
        }

*/

        pomodoro_technique.setOnClickListener {
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            } else {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
            }
        }

        pt_ft_hour_data_ic.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                if (pomodoroTechniqueFocusTimeHourData < 24){
                    pomodoroTechniqueFocusTimeHourData+=1
                    pomodoroTechniqueFocusTimeHourDataString = pomodoroTechniqueFocusTimeHourData.toString()
                    pt_ft_hour_data.text = pomodoroTechniqueFocusTimeHourDataString
                }
                else {
                    pomodoroTechniqueFocusTimeHourData = 0
                    pomodoroTechniqueFocusTimeHourDataString = pomodoroTechniqueFocusTimeHourData.toString()
                    pt_ft_hour_data.text = pomodoroTechniqueFocusTimeHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        pt_ft_hour_data_dc.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                if (pomodoroTechniqueFocusTimeHourData > 0){
                    if(pomodoroTechniqueFocusTimeHourData>pomodoroTechniqueIntervalHourData){
                        pomodoroTechniqueFocusTimeHourData-=1
                        pomodoroTechniqueFocusTimeHourDataString = pomodoroTechniqueFocusTimeHourData.toString()
                        pt_ft_hour_data.text = pomodoroTechniqueFocusTimeHourDataString
                    }
                    else{
                        val toast = Toast.makeText(this, "Focus Time Could Not be Less then Interval Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }
                else{
                    pomodoroTechniqueFocusTimeHourData = 24
                    pomodoroTechniqueFocusTimeHourDataString = pomodoroTechniqueFocusTimeHourData.toString()
                    pt_ft_hour_data.text = pomodoroTechniqueFocusTimeHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        pt_ft_minutes_data_ic.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                if (pomodoroTechniqueFocusTimeMinutesData < 60){
                    pomodoroTechniqueFocusTimeMinutesData+=5
                    pomodoroTechniqueFocusTimeMinutesDataString = pomodoroTechniqueFocusTimeMinutesData.toString()
                    pt_ft_minutes_data.text = pomodoroTechniqueFocusTimeMinutesDataString
                }
                else {
                    pomodoroTechniqueFocusTimeMinutesData = 0
                    pomodoroTechniqueFocusTimeMinutesDataString = pomodoroTechniqueFocusTimeMinutesData.toString()
                    pt_ft_minutes_data.text = pomodoroTechniqueFocusTimeMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        pt_ft_minutes_data_dc.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                PTtotalFocusTimeMinutes = pomodoroTechniqueFocusTimeHourData*60+pomodoroTechniqueFocusTimeMinutesData
                PTtotalIntervalMinutes = pomodoroTechniqueIntervalHourData*60+pomodoroTechniqueIntervalMinutesData
                if (pomodoroTechniqueFocusTimeMinutesData > 0){
                    if(PTtotalIntervalMinutes<PTtotalFocusTimeMinutes){
                        pomodoroTechniqueFocusTimeMinutesData-=5
                        pomodoroTechniqueFocusTimeMinutesDataString = pomodoroTechniqueFocusTimeMinutesData.toString()
                        pt_ft_minutes_data.text = pomodoroTechniqueFocusTimeMinutesDataString
                        PTtotalFocusTimeMinutes = pomodoroTechniqueFocusTimeHourData*60+pomodoroTechniqueFocusTimeMinutesData
                        PTtotalIntervalMinutes = pomodoroTechniqueIntervalHourData*60+pomodoroTechniqueIntervalMinutesData
                    }
                    else{
                        val toast = Toast.makeText(this, "Focus Time Could Not be Less then Interval Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }
                else{
                    pomodoroTechniqueFocusTimeHourData-=1
                    pomodoroTechniqueFocusTimeHourDataString = pomodoroTechniqueFocusTimeHourData.toString()
                    pt_ft_hour_data.text = pomodoroTechniqueFocusTimeHourDataString

                    pomodoroTechniqueFocusTimeMinutesData = 60
                    pomodoroTechniqueFocusTimeMinutesDataString = pomodoroTechniqueFocusTimeMinutesData.toString()
                    pt_ft_minutes_data.text = pomodoroTechniqueFocusTimeMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        pt_I_hour_data_ic.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                if (pomodoroTechniqueIntervalHourData < 24 && pomodoroTechniqueIntervalHourData<pomodoroTechniqueFocusTimeHourData){
                    pomodoroTechniqueIntervalHourData+=1
                    pomodoroTechniqueIntervalHourDataString = pomodoroTechniqueIntervalHourData.toString()
                    pt_I_hour_data.text = pomodoroTechniqueIntervalHourDataString
                }
                else {
                    val toast = Toast.makeText(this, "Interval Time Could Not be Greater then Focus Time", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        pt_I_hour_data_dc.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                if (pomodoroTechniqueIntervalHourData > 0){
                    pomodoroTechniqueIntervalHourData-=1
                    pomodoroTechniqueIntervalHourDataString = pomodoroTechniqueIntervalHourData.toString()
                    pt_I_hour_data.text = pomodoroTechniqueIntervalHourDataString
                }
                else{
                    pomodoroTechniqueIntervalHourData = pomodoroTechniqueFocusTimeHourData
                    pomodoroTechniqueIntervalHourDataString = pomodoroTechniqueIntervalHourData.toString()
                    pt_I_hour_data.text = pomodoroTechniqueIntervalHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        pt_I_minutes_data_ic.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                pomodoro_technique.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                pt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                PTtotalFocusTimeMinutes = pomodoroTechniqueFocusTimeHourData*60+pomodoroTechniqueFocusTimeMinutesData
                PTtotalIntervalMinutes = pomodoroTechniqueIntervalHourData*60+pomodoroTechniqueIntervalMinutesData

                if (pomodoroTechniqueIntervalMinutesData < 59){
                    if(PTtotalIntervalMinutes<PTtotalFocusTimeMinutes){
                        pomodoroTechniqueIntervalMinutesData+=5
                        pomodoroTechniqueIntervalMinutesDataString = pomodoroTechniqueIntervalMinutesData.toString()
                        pt_I_minutes_data.text = pomodoroTechniqueIntervalMinutesDataString
                        PTtotalFocusTimeMinutes = pomodoroTechniqueFocusTimeHourData*60+pomodoroTechniqueFocusTimeMinutesData
                        PTtotalIntervalMinutes = pomodoroTechniqueIntervalHourData*60+pomodoroTechniqueIntervalMinutesData
                    }
                    else {
                        val toast = Toast.makeText(this, "Interval Time Could Not be Greater then Focus Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }
                else{
                    pomodoroTechniqueIntervalHourData+=1
                    pomodoroTechniqueIntervalHourDataString = pomodoroTechniqueIntervalHourData.toString()
                    pt_I_hour_data.text = pomodoroTechniqueIntervalHourDataString

                    pomodoroTechniqueIntervalMinutesData = 0
                    pomodoroTechniqueIntervalMinutesDataString = pomodoroTechniqueIntervalMinutesData.toString()
                    pt_I_minutes_data.text = pomodoroTechniqueIntervalMinutesDataString
                }

            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        pt_I_minutes_data_dc.setOnClickListener{
            if (pomodoro_technique.cardBackgroundColor == selectedColor){
                if (pomodoro_technique.cardBackgroundColor == nonSelectedColor) {
                    pomodoro_technique.setCardBackgroundColor(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.selectedColor
                        )
                    )
                    pt_ft.setCardBackgroundColor(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.selectedColor
                        )
                    )
                    pt_I.setCardBackgroundColor(
                        ContextCompat.getColor(
                            applicationContext,
                            R.color.selectedColor
                        )
                    )
                }
                if (pomodoroTechniqueIntervalMinutesData > 0){
                    pomodoroTechniqueIntervalMinutesData-=5
                    pomodoroTechniqueIntervalMinutesDataString = pomodoroTechniqueIntervalMinutesData.toString()
                    pt_I_minutes_data.text = pomodoroTechniqueIntervalMinutesDataString
                }
                else{
                    pomodoroTechniqueIntervalHourData-=1
                    pomodoroTechniqueIntervalHourDataString = pomodoroTechniqueIntervalHourData.toString()
                    pt_I_hour_data.text = pomodoroTechniqueIntervalHourDataString

                    pomodoroTechniqueIntervalMinutesData = 60
                    pomodoroTechniqueIntervalMinutesDataString = pomodoroTechniqueIntervalMinutesData.toString()
                    pt_I_minutes_data.text = pomodoroTechniqueIntervalMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The Pomodoro Technique Reminder ... ", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        pt_RT_button.setOnClickListener{
            if(pomodoroTechniqueReminderTime < 5){
                pomodoroTechniqueReminderTime++
                pomodoroTechniqueReminderTimeString = pomodoroTechniqueReminderTime.toString()
                pt_RT_data.text = pomodoroTechniqueReminderTimeString
            }
            else if(pomodoroTechniqueReminderTime in 5..29){
                pomodoroTechniqueReminderTime += 5
                pomodoroTechniqueReminderTimeString = pomodoroTechniqueReminderTime.toString()
                pt_RT_data.text = pomodoroTechniqueReminderTimeString
            }
            else if(pomodoroTechniqueReminderTime == 30) {
                pomodoroTechniqueReminderTime = 1
                pomodoroTechniqueReminderTimeString = pomodoroTechniqueReminderTime.toString()
                pt_RT_data.text = pomodoroTechniqueReminderTimeString
            }
        }




        _20_20_20_rule.setOnClickListener {
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            } else {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.nonSelectedColor
                    )
                )
            }


        }

        tt_ft_hour_data_ic.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                if (twentyTwentyRuleFocusTimeHourData < 24){
                    twentyTwentyRuleFocusTimeHourData+=1
                    twentyTwentyRuleFocusTimeHourDataString = twentyTwentyRuleFocusTimeHourData.toString()
                    tt_ft_hour_data.text = twentyTwentyRuleFocusTimeHourDataString
                }
                else {
                    twentyTwentyRuleFocusTimeHourData = 0
                    twentyTwentyRuleFocusTimeHourDataString = twentyTwentyRuleFocusTimeHourData.toString()
                    tt_ft_hour_data.text = twentyTwentyRuleFocusTimeHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        tt_ft_hour_data_dc.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                if (twentyTwentyRuleFocusTimeHourData > 0){
                    if(twentyTwentyRuleFocusTimeHourData>drinkingWaterIntervalHourData){
                        twentyTwentyRuleFocusTimeHourData-=1
                        twentyTwentyRuleFocusTimeHourDataString = twentyTwentyRuleFocusTimeHourData.toString()
                        tt_ft_hour_data.text = twentyTwentyRuleFocusTimeHourDataString
                    }
                    else{
                        val toast = Toast.makeText(this, "Focus Time Could Not be Less then Interval Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }
                else{
                    twentyTwentyRuleFocusTimeHourData = 24
                    twentyTwentyRuleFocusTimeHourDataString = twentyTwentyRuleFocusTimeHourData.toString()
                    tt_ft_hour_data.text = twentyTwentyRuleFocusTimeHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        tt_ft_minutes_data_ic.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                if (twentyTwentyRuleFocusTimeMinutesData < 60){
                    twentyTwentyRuleFocusTimeMinutesData+=5
                    twentyTwentyRuleFocusTimeMinutesDataString = twentyTwentyRuleFocusTimeMinutesData.toString()
                    tt_ft_minutes_data.text = twentyTwentyRuleFocusTimeMinutesDataString
                }
                else {
                    twentyTwentyRuleFocusTimeMinutesData = 0
                    twentyTwentyRuleFocusTimeMinutesDataString = twentyTwentyRuleFocusTimeMinutesData.toString()
                    tt_ft_minutes_data.text = twentyTwentyRuleFocusTimeMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        tt_ft_minutes_data_dc.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                TTTtotalFocusTimeMinutes = twentyTwentyRuleFocusTimeHourData*60+twentyTwentyRuleFocusTimeMinutesData
                TTTtotalIntervalMinutes = twentyTwentyRuleIntervalHourData*60+twentyTwentyRuleIntervalMinutesData
                if (twentyTwentyRuleFocusTimeMinutesData > 0){
                    if(TTTtotalIntervalMinutes<TTTtotalFocusTimeMinutes){
                        twentyTwentyRuleFocusTimeMinutesData-=5
                        twentyTwentyRuleFocusTimeMinutesDataString = twentyTwentyRuleFocusTimeMinutesData.toString()
                        tt_ft_minutes_data.text = twentyTwentyRuleFocusTimeMinutesDataString
                        TTTtotalFocusTimeMinutes = twentyTwentyRuleFocusTimeHourData*60+twentyTwentyRuleFocusTimeMinutesData
                        TTTtotalIntervalMinutes = twentyTwentyRuleIntervalHourData*60+twentyTwentyRuleIntervalMinutesData
                    }
                    else{
                        val toast = Toast.makeText(this, "Focus Time Could Not be Less then Interval Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }
                }
                else{
                    twentyTwentyRuleFocusTimeHourData-=1
                    twentyTwentyRuleFocusTimeHourDataString = twentyTwentyRuleFocusTimeHourData.toString()
                    tt_ft_hour_data.text = twentyTwentyRuleFocusTimeHourDataString

                    twentyTwentyRuleFocusTimeMinutesData = 60
                    twentyTwentyRuleFocusTimeMinutesDataString = twentyTwentyRuleFocusTimeMinutesData.toString()
                    tt_ft_minutes_data.text = twentyTwentyRuleFocusTimeMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        tt_I_hour_data_ic.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                if (twentyTwentyRuleIntervalHourData < 24 && twentyTwentyRuleIntervalHourData<twentyTwentyRuleFocusTimeHourData){
                    twentyTwentyRuleIntervalHourData+=1
                    twentyTwentyRuleIntervalHourDataString = twentyTwentyRuleIntervalHourData.toString()
                    tt_I_hour_data.text = twentyTwentyRuleIntervalHourDataString
                }
                else {
                    val toast = Toast.makeText(this, "Interval Time Could Not be Greater then Focus Time", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        tt_I_hour_data_dc.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                if (twentyTwentyRuleIntervalHourData > 0){
                    twentyTwentyRuleIntervalHourData-=1
                    twentyTwentyRuleIntervalHourDataString = twentyTwentyRuleIntervalHourData.toString()
                    tt_I_hour_data.text =twentyTwentyRuleIntervalHourDataString
                }
                else{
                    twentyTwentyRuleIntervalHourData = twentyTwentyRuleFocusTimeHourData
                    twentyTwentyRuleIntervalHourDataString = twentyTwentyRuleIntervalHourData.toString()
                    tt_I_hour_data.text = twentyTwentyRuleIntervalHourDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        tt_I_minutes_data_ic.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (drinking_water.cardBackgroundColor == selectedColor){
                TTTtotalFocusTimeMinutes = twentyTwentyRuleFocusTimeHourData*60+twentyTwentyRuleFocusTimeMinutesData
                TTTtotalIntervalMinutes = twentyTwentyRuleIntervalHourData*60+twentyTwentyRuleIntervalMinutesData

                if (twentyTwentyRuleIntervalMinutesData < 59){
                    if(TTTtotalIntervalMinutes<TTTtotalFocusTimeMinutes){
                        twentyTwentyRuleIntervalMinutesData+=5
                        twentyTwentyRuleIntervalMinutesDataString = twentyTwentyRuleIntervalMinutesData.toString()
                        tt_I_minutes_data.text = twentyTwentyRuleIntervalMinutesDataString
                        TTTtotalFocusTimeMinutes = twentyTwentyRuleFocusTimeHourData*60+twentyTwentyRuleFocusTimeMinutesData
                        TTTtotalIntervalMinutes = twentyTwentyRuleIntervalHourData*60+twentyTwentyRuleIntervalMinutesData
                    }
                    else {
                        val toast = Toast.makeText(this, "Interval Time Could Not be Greater then Focus Time", Toast.LENGTH_SHORT)
                        toast.show()
                    }

                }
                else{
                    twentyTwentyRuleIntervalHourData+=1
                    twentyTwentyRuleIntervalHourDataString = twentyTwentyRuleIntervalHourData.toString()
                    tt_I_hour_data.text = twentyTwentyRuleIntervalHourDataString

                    twentyTwentyRuleIntervalMinutesData = 0
                    twentyTwentyRuleIntervalMinutesDataString = twentyTwentyRuleIntervalMinutesData.toString()
                    tt_I_minutes_data.text = twentyTwentyRuleIntervalMinutesDataString
                }

            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }
        tt_I_minutes_data_dc.setOnClickListener{
            if (_20_20_20_rule.cardBackgroundColor == nonSelectedColor) {
                _20_20_20_rule.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_ft.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
                tt_I.setCardBackgroundColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.selectedColor
                    )
                )
            }
            if (_20_20_20_rule.cardBackgroundColor == selectedColor){
                if (twentyTwentyRuleIntervalMinutesData > 0){
                    twentyTwentyRuleIntervalMinutesData-=5
                    twentyTwentyRuleIntervalMinutesDataString = twentyTwentyRuleIntervalMinutesData.toString()
                    tt_I_minutes_data.text = twentyTwentyRuleIntervalMinutesDataString
                }
                else{
                    twentyTwentyRuleIntervalHourData-=1
                    twentyTwentyRuleIntervalHourDataString = twentyTwentyRuleIntervalHourData.toString()
                    tt_I_hour_data.text = twentyTwentyRuleIntervalHourDataString

                    twentyTwentyRuleIntervalMinutesData = 60
                    twentyTwentyRuleIntervalMinutesDataString = twentyTwentyRuleIntervalMinutesData.toString()
                    tt_I_minutes_data.text = twentyTwentyRuleIntervalMinutesDataString

                }
            }
            else {
                val toast = Toast.makeText(this, "Please Enable The 20/20/20 Rule Reminder...", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        tt_RT_button.setOnClickListener{
            if(twentyTwentyRuleReminderTime < 5){
                twentyTwentyRuleReminderTime++
                twentyTwentyRuleReminderTimeString = twentyTwentyRuleReminderTime.toString()
                tt_RT_data.text = twentyTwentyRuleReminderTimeString
            }
            else if(twentyTwentyRuleReminderTime in 5..29){
                twentyTwentyRuleReminderTime += 5
                twentyTwentyRuleReminderTimeString = twentyTwentyRuleReminderTime.toString()
                tt_RT_data.text = twentyTwentyRuleReminderTimeString
            }
            else if(twentyTwentyRuleReminderTime == 30) {
                twentyTwentyRuleReminderTime = 1
                twentyTwentyRuleReminderTimeString = twentyTwentyRuleReminderTime.toString()
                tt_RT_data.text = twentyTwentyRuleReminderTimeString
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "Drinking Water Reminder"
            val description = "Channel For WorkEfi"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("workEfi", name, importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager ::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }


}

