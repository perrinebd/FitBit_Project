# BitFit
360 Project
Brett Perrine & Luke Bradley

BitFit is an application that simulates gathering, accepting, and displaying data from an accelerometer and stopwatch.
Here's how to set it up:

1. Clone or download the repository to your desktop. 
2. Open your favorite IDE and create a new project.
3. Import the "src" folder and all of its contents into your project.
4. Run the project.

You will begin the program in the ViewSelector menu. You can either choose the StepCounter or the StopWatch checkboxes
(the Heart Rate Monitor box does not have full implementation at this time). After you select one of the two checkboxes,
the window corresponding to that checkbox will open.

# StepCounter:
In this window, you will see two numbers: one corresponding to current number of steps taken since last log, and total
number of steps. The current steps number will increase every 1.5 seconds to simulate taking steps. When you select the
"Log Steps" button, the current number of steps will be added to the total number, and the current number will start over
again from 1. You can also select the "Change View" button to go back to the main ViewSelector menu.

# StopWatch:
In this window, you will see two numbers separated by a colon, representing the minutes and seconds of a stopwatch. When
you select the "Start" button, the seconds value will start counting up, and "Start" will be replaced with "Reset." When
you press "Stop", the timer will freeze. When you hit "Reset", the timer will start over from 0 seconds again. You can also
select the "Change View" button to go back to the main ViewSelector menu.

Have fun!
