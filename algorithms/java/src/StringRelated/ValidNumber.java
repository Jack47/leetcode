package StringRelated;

// Validate if a given string is numeric
// https://leetcode.com/problems/valid-number/?tab=Description
public class ValidNumber {

    private enum State {
        Begin,
        Sign,
        Integer,
        SkipIntegerPoint,
        Point,
        Fraction,
        E,
        E_And_Sign,
        ScientificNotation,
    }

    public boolean isNumber(String s) {
        State state = State.Begin;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (state == State.Begin) {
                    state = State.Sign;
                } else if (state == State.E) {
                    state = state.E_And_Sign;
                }
                else {
                    return false;
                }
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                switch (state) {
                    case Begin:
                    case Sign:
                    case Integer:
                        state = State.Integer;
                        break;
                    case Point:
                    case SkipIntegerPoint:
                    case Fraction:
                        state = State.Fraction;
                        break;
                    case E:
                    case E_And_Sign:
                    case ScientificNotation:
                        state = State.ScientificNotation;
                        break;
                    default:
                        System.out.printf("State unkown: %s", state);
                        break;
                }
            } else if (s.charAt(i) == '.') {
                if (state == State.Begin || state == State.Sign) {
                    state = State.SkipIntegerPoint;
                } else if (state == State.Integer) {
                    state = State.Point;
                } else {
                    return false;
                }
            } else if ((s.charAt(i) == 'E' || s.charAt(i) == 'e') && (state == State.Integer
                    || state == State.Fraction || state == State.Point)) {
                state = State.E;
            } else {
                return false;
            }
        }
        return state == State.Integer || state == State.Fraction
                || state == State.ScientificNotation || state == State.Point;
    }
}
