/*
 * Copyright (C) 2009-2010 Mathias Doenitz
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

package org.parboiled.parserunners;

import org.parboiled.Parboiled;
import org.parboiled.examples.calculators.CalculatorParser1;
import org.parboiled.support.ParsingResult;
import org.parboiled.test.AbstractTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TracingParseRunnerTest extends AbstractTest {

    @Test
    public void testTracingParseRunner() {
        CalculatorParser1 parser = Parboiled.createParser(CalculatorParser1.class);
        TracingParseRunner runner = new TracingParseRunner(parser.InputLine());
        ParsingResult result = runner.run("2*(4+5)");

        assertEquals(result.resultValue, 18);
        assertEquals(runner.getLog(), "" +
                "Starting match on rule 'InputLine'\n" +
                "InputLine/Expression/Term/Factor/Number/Digits/Digit: matched, cursor is at line 1, col 2: \"2\"\n" +
                "InputLine/Expression/Term/Factor/Number/Digits/Digit: failed, cursor is at line 1, col 2: \"2\"\n" +
                "InputLine/Expression/Term/Factor/Number/Digits: matched, cursor is at line 1, col 2: \"2\"\n" +
                "InputLine/Expression/Term/Factor/Number/Number_Action1: matched, cursor is at line 1, col 2: \"2\"\n" +
                "InputLine/Expression/Term/Factor/Number: matched, cursor is at line 1, col 2: \"2\"\n" +
                "InputLine/Expression/Term/Factor: matched, cursor is at line 1, col 2: \"2\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/'*': matched, cursor is at line 1, col 3: \"2*\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Number/Digits/Digit: failed, cursor is at line 1, col 3: \"2*\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Number/Digits: failed, cursor is at line 1, col 3: \"2*\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Number: failed, cursor is at line 1, col 3: \"2*\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/'(': matched, cursor is at line 1, col 4: \"2*(\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/Factor/Number/Digits/Digit: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/Factor/Number/Digits/Digit: failed, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/Factor/Number/Digits: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/Factor/Number/Number_Action1: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/Factor/Number: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/Factor: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/ZeroOrMore/FirstOf/Sequence/'*': failed, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/ZeroOrMore/FirstOf/Sequence/'/': failed, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/ZeroOrMore/FirstOf: failed, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term/ZeroOrMore: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/Term: matched, cursor is at line 1, col 5: \"2*(4\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/'+': matched, cursor is at line 1, col 6: \"2*(4+\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/Factor/Number/Digits/Digit: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/Factor/Number/Digits/Digit: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/Factor/Number/Digits: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/Factor/Number/Number_Action1: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/Factor/Number: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/Factor: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/ZeroOrMore/FirstOf/Sequence/'*': failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/ZeroOrMore/FirstOf/Sequence/'/': failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/ZeroOrMore/FirstOf: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term/ZeroOrMore: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Term: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/Expression_Action1: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/'+': failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence/'-': failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore/FirstOf: failed, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression/ZeroOrMore: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/Expression: matched, cursor is at line 1, col 7: \"2*(4+5\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens/')': matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor/Parens: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Factor: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/Term_Action1: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/'*': failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence/'/': failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore/FirstOf: failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term/ZeroOrMore: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/Term: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/ZeroOrMore/FirstOf/Sequence/'+': failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/ZeroOrMore/FirstOf/Sequence/'-': failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/ZeroOrMore/FirstOf/Sequence: failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/ZeroOrMore/FirstOf: failed, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression/ZeroOrMore: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/Expression: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine/EOI: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n" +
                "InputLine: matched, cursor is at line 1, col 8: \"2*(4+5)\"\n");
    }

}