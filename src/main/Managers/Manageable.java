package Managers;
// Developed by John Park and Rahul Jaideep

import MatchingAlgoHelpers.Matchable;
import MatchingAlgoHelpers.Schedulable;

// This interface extends both the Matchable and Schedulable interfaces so that the
// Manager class can call upon users (manageable objects) that .
public interface Manageable extends Matchable, Schedulable {
}
