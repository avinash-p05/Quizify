package com.example.quizapp

object constants {

    const val  USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"



    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "What's this company name?",
            R.drawable.mastercard,
            "MasterCard",
            "Maestro",
            "Penguin Books",
            "Goodyear",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Choose the name.",
            R.drawable.michelin,
            "Bridgestone",
            "Continental",
            "Michelin",
            "Goodyear",
            3
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Name the company",
            R.drawable.playboy,
            "Hopper",
            "Playboy",
            "Fluffy",
            "Fancy Feast",
            2
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Can you guess the company name by its logo?",
            R.drawable.target,
            "Showtime",
            "Target",
            "Oracle",
            "Coach",
            2
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "What brand is this?",
            R.drawable.lacoste,
            "Lacoste",
            "Gucci",
            "Armani",
            "Nike",
            1
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "Name the company",
            R.drawable.america,
            "Bank of America",
            "American Eagle",
            "America Express",
            "ABSD",
            1

        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "Name the company",
            R.drawable.xerox,
            "XP",
            "XTO Energy",
            "Xerox",
            "X-Men",
            3
        )
        questionsList.add(que7)

        val que8 = Question(
            8,
            "How is it called?",
            R.drawable.volvo,
            "Sony",
            "Honda",
            "BMW",
            "Volvo",
            4

        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "What brand is this?",
            R.drawable.levis,
            "North Face",
            "Reebok",
            "Levis",
            "Superdry",
            3
        )
        questionsList.add(que9)

        val que10 = Question(
            10,
            "Name the company",
            R.drawable.goodyear,
            "BFGoodrich",
            "Bridgestone",
            "Goodyear",
            "Firestone",
            3
        )
        questionsList.add(que10)


        return questionsList
    }


}