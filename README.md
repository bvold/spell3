# Spell3: A Phonetic Journey Through 25 Years of Code (and Misspellings)

**About:**

In the hazy depths of 1998 (okay, fine, it was closer to 25 years ago), a fascination with Microsoft Word's spellcheck magic led me down a rabbit hole. The result? A phonetic spell checker, lovingly crafted in Java! (See the original code here: [Spell3](https://github.com/bvold/spell3/tree/main)).

**Fast forward to 2023:** I rediscovered this code and a wave of nostalgia (and surprise) washed over me. Surprise, you ask? That phonetic tools haven't exactly exploded in popularity. In fact, some of the suggested corrections I see still leave me scratching my head.

**So, here I am, embarking on a new adventure:** rewriting Spell3 in Rust! Two goals fuel this journey: learning a new language and making the code sing with efficiency.

**The Algorithm:**

My inspiration came from a pair of trusty Merriam Webster dictionaries. They whispered secrets of English: sounds, symbols, spellings – a treasure trove for a budding phonetician (I may not have the lingo down perfectly, but that's part of the fun!).

Here's the gist:

1. **Break it down:** A word gets chopped into its base sounds (phonemes).
2. **Sound by sound:** For each phoneme, we explore all possible spellings.
3. **Reverse engineering:** We reassemble these potential spellings, creating a vast universe of candidate words.
4. **Dictionary dive:** We scour the dictionary (originally /usr/dict/words, now a fancy /usr/share/dict/words resident) for matches.

**Testing, testing:**

The first victim? "Laff". While technically acceptable in some circles (OED, I'm looking at you!), my brute-force approach happily suggested "laugh" as the one-and-only solution.

Then came "ghoti". This linguistic unicorn, with its /gh/, /o/, and /ti/ sounding suspiciously like "fish", became my ultimate test. Did Spell3 crack the code? You bet it did! A testament to the beauty (and occasional absurdity) of the naive approach.

**The Future:**

My mind is abuzz with new ideas. The algorithm is getting a re-work, inspired by the wonders of the Carnegie Mellon Pronouncing Dictionary. And, yes, "one" and its sneaky pronunciation ("won", not "own") are definitely on my radar.

**Bonus Round:**

Did I mention ternary search trees? This algorithm, published in Dr. Dobb's Journal just before I started coding Spell3, became the backbone of the original program.

**So, if you're still here, thanks for sticking around! This is just the beginning of Spell3's second chapter. Stay tuned for more code, linguistic quirks, and (hopefully) fewer typos.**

**P.S.:** Feel free to contribute, suggest, and join the journey! The code is open-source and ready for your input. Let's build a better spellchecker, together.

**Happy coding!:smile:**
