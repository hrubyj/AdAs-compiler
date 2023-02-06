grammar AdAs;

program
    : functionDeclaration* mainFunctionDeclaration
    ;

declaration
    : typeQualifier? nonVoidTypeSpecifier Identifier (EqualSign assignableValue)? Semi
    | arrayTypeSpecifier Identifier (EqualSign functionCall)? Semi
    ;

assignment
    : Identifier EqualSign assignableValue Semi
    | arrayAccess EqualSign assignableValue Semi
    ;

assignableValue
    : nonVoidReturnValue
    ;

arrayAccess
    : Identifier LeftBracket decimalConstant RightBracket
    ;

statement
    :   conditionalStatement
    |   iterationStatement
    ;

iterationStatement
    :   whileCondition scope
    |   Do scope whileCondition
    |   forLoop
    ;

forLoop
    : For LeftParen Identifier In (Identifier | NonzeroConstant) RightParen scope
    ;

labeledStatement
    :   Case signedConstant Colon scope
    |   Default Colon scope
    ;

returnStatement
    : Return returnExpression? Semi
    ;

conditionalStatement
    : If condition scope (Else scope)?
    | Switch nonVoidReturnValue LeftBrace labeledStatement+ RightBrace
    ;

blockItemList
    :   blockItem+
    ;

blockItem
    :   statement
    |   declaration
    |   assignment
    ;

returnExpression
    :   Identifier
    |   arrayAccess
    |   signedConstant
    |   BooleanLiteral
    ;

nonVoidReturnValue
    : functionCall
    | BooleanLiteral
    | signedConstant
    | Identifier
    | arrayAccess
    ;

scope
    : LeftBrace blockItemList? RightBrace
    ;

functionScope
    : LeftBrace blockItemList? returnStatement RightBrace
    ;

condition
    : LeftParen conditionBody RightParen
    | logicalOperation
    ;

conditionBody
    : BooleanLiteral
    | Identifier
    | arrayAccess
    ;

whileCondition
    : While condition
    ;

functionDeclaration
    : Function functionReturnType Identifier LeftParen functionDeclParams? RightParen functionScope
    ;

functionReturnType
    : baseTypeSpecifier
    | arrayTypeSpecifier
    ;

mainFunctionDeclaration
    : Function Void Main LeftParen RightParen functionScope
    ;

functionDeclParams
    : functionDeclParam (Comma functionDeclParam)*
    ;

functionDeclParam
    : (nonVoidTypeSpecifier | arrayTypeSpecifier) Identifier
    ;

functionCall
    : LeftParen customFunctionIdentifier (Comma functionCallParam)* RightParen
    | LeftParen baseFunctionIdentifier Comma functionCallParam Comma functionCallParam RightParen
    | LeftParen unaryOperator Comma functionCallParam RightParen
    ;

logicalOperation
    : LeftParen (logicalOperator | comparisonOperator) Comma functionCallParam Comma functionCallParam RightParen
    ;

functionCallParam
    : Identifier
    | BooleanLiteral
    | decimalConstant
    | arrayAccess
    | functionCall
    ;

customFunctionIdentifier
    : Identifier
    ;

baseFunctionIdentifier
    : comparisonOperator
    | arithmeticOperator
    | logicalOperator
    ;

arrayTypeSpecifier
    : nonVoidTypeSpecifier LeftBracket NonzeroConstant RightBracket
    ;

baseTypeSpecifier
    : nonVoidTypeSpecifier
    | Void
    ;

nonVoidTypeSpecifier
    : Int
    | Bool
    ;

typeQualifier
    : Const
    ;

unaryOperator
    : Negate
    | Minus
    ;

comparisonOperator
    : Less
    | LessEqual
    | Greater
    | GreaterEqual
    | Equal
    ;

arithmeticOperator
    : Plus
    | Minus
    | Div
    | Star
    | Mod
    ;

logicalOperator
    : And
    | Or
    ;

signedConstant
    :   (Plus | Minus)? decimalConstant
    ;


decimalConstant
    :   NonzeroConstant
    | '0'
    ;

Const : 'const';
If : 'if';
Switch : 'switch';
Case : 'case';
Default : 'default';
Function : 'function';
Int : 'int';
Bool : 'bool';
Void : 'void';
For : 'for';
In : 'in';
While : 'while';
Else : 'else';
Do : 'do';
Instanceof : 'instanceof';
Return : 'return';
Main : 'main';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
Equal : '==';

And : 'AND';
Or : 'OR';
Negate: '!';

EqualSign : '=';
Plus : '+';
Minus : '-';
Star : '*';
Div : '/';
Mod : '%';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

BooleanLiteral
    : 'true'
    | 'false'
    ;

Identifier
    :   Nondigit (Nondigit)*
    ;

fragment
Nondigit
    : [a-zA-Z]
    ;

fragment
Digit
    :   [0-9]
    ;

fragment
NonzeroDigit
    :   [1-9]
    ;


NonzeroConstant
    : NonzeroDigit Digit*
    ;

DigitSequence
    :   Digit+
    ;

NonzeroDigitSequence
    : NonzeroDigit+
    ;

fragment
Sign
    :   [+-]
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;