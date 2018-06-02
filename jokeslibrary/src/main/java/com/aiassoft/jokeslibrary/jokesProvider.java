/**
 * Copyright (C) 2018 by George Vrynios
 * This project was made under the supervision of Udacity
 * in the Android Developer Nanodegree Program
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aiassoft.jokeslibrary;

import java.util.Random;

/**
 * Created by gvryn on 02/06/18.
 */

public class jokesProvider {

    /**
     * We will never need to create an instance of the jokesProvider class
     */    private jokesProvider() {
        throw new AssertionError("No Instances for you!");
    }

    //private static int jokePos = 0;

    /**
     * The jokes are provident from https://www.rd.com/joke
     */
    private static String[] jokesHiHi = {
            "Q: When do you go at red and stop at green?\n\nA: When you\u2019re eating a watermelon.",
            "Knock! Knock! Who\u2019s there? A broken pencil. A broken pencil who? Never mind, it\u2019s pointless.",
            "The majority of Americans find bananas a peeling.",
            "Boy, I just got hit in the head with a can of soda. I was lucky it was a soft drink.",
            "Q: What do you call a round, green vegetable that breaks out of prison?\n\nA: An escapea.",
            "My granddaughter told me, \u201CDon\u2019t buy brown eggs; they\u2019re not ripe yet.\u201D",
            "Did you hear about the Italian chef with a terminal illness? He pastaway.",
            "It was an emotional wedding. Even the cake was in tiers.",
            "Q. Which type of vegetable tries to be cool, but is only partly successful at it?\n\nA. The radish.",
            "I can\u2019t stand potato puns. I think they\u2019re pomme de terrible.",
            "Q: How do you get a hipster to eat a hot dog?\n\nA: Put it in a man bun.",
            "Q: What are hot dogs called in winter?\n\nA: Chilly dogs",
            "A lot of people cry when they cut onions. The trick is not to form an emotional bond.",
            "The price of candy at the movie theater is ridiculous. They\u2019re always raisinet!",
            "Q: What do you get when you play Tug-of-War with a pig?\n\nA: Pulled-Pork.",
            "I love when candy canes are in mint condition.",
            "A guy just threw a glass of milk at me. How dairy!",
            "Q. How do you keep intruders out of a castle made of cheese?\n\nA. Moatzarella.",
            "Q. What\u2019s the difference between a shamrock and a bread knife that gets used a lot?\n\nA. The shamrock is a four-leaf clover, and the knife is a four-loaf cleaver.",
            "Q: Why do hamburgers go to the gym?\n\nA: To get better buns.",
            "Q: What do you call the king of vegetables?\n\nA: Elvis Parsley.",
            "I wrote a song about a tortilla. Well actually, it\u2019s more of a wrap.",
            "Q: What do you call cheese that is sad?\n\nA: Blue cheese.",
            "Q: Did you hear the one about the greedy peanut butter?\n\nA: I\u2019m not telling you. You might spread it."
    };

    public static String anotherJoke() {
        return jokesHiHi[new Random().nextInt(jokesHiHi.length)];
//        if (jokePos >= jokesHiHi.length) {
//            jokePos = 0;
//        }
//        return jokesHiHi[jokePos++];
    }

}
