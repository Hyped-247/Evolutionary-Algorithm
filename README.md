# Evolutionary-Algorithm

## Things to do (mainly of a refactor nature)

* commit messages should be more informative than a few words
* refactor constructors in Individual so that one calls the other
which does all the work
* refactor the reproduce method into: getRandomSplits(numSplits),
that returns a list of split point, and sliceAndDice(splits, parent1, parent2),
which returns a list of two children
* refactor whoLives() using: Collections.swap()
to manage the individuals eligible for a tournament
(where previous survivors are not eligible
although previous participants are);
see the problem with population.remove(winner);
each tournament of a given size should consist of distinct individuals
(i.e., whereas individuals can reproduce multiple times,
they cannot compete in a single tournament multiple times);
but note: an individual cannot reproduce with itself
* testing: adopt adversarial mindset for creating tests
* consolidate use of Random so that within a class
(or even across entire application)
only one instance of Random is created and used;
this is helpful for running controlled experiments
where one may want to repeate the exact same sequence of random numbers
