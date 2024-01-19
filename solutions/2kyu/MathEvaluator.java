/*
    kata link
    https://www.codewars.com/kata/52a78825cdfc2cfc87000005
*/

import java.util.HashMap;
import java.util.Map;

public class MathEvaluator {
    private Map<Character, Integer>  operatorDegree = new HashMap<>();
    private Node head;
    MathEvaluator(){
        
// each arithmitique sign associated with its power 
        operatorDegree.put('+', 0);
        operatorDegree.put('-', 1);
        operatorDegree.put('*', 2);
        operatorDegree.put('/', 3);
        operatorDegree.put('^', 3);
        operatorDegree.put('(', 4);
// you can add as many operator as u want
      
    }
    public double calculate(String expression) {
        System.out.println(expression);
        head = expressionToTree(expression);
        return evaluateTree(head);
    }
    private double evaluateTree(Node node) {
        if (node == null)
            return 0;
        String value = node.getValue();
        switch (value) {
            case "*" -> {
                return evaluateTree(node.getLeft()) * evaluateTree(node.getRight());
            }
            case "/" -> {
                return evaluateTree(node.getLeft()) / evaluateTree(node.getRight());
            }
            case "+" -> {
                return evaluateTree(node.getLeft()) + evaluateTree(node.getRight());
            }
            case "-" -> {
                if (node.getLeft() == null)
                    return -1 * evaluateTree(node.getRight());
                return evaluateTree(node.getLeft()) - evaluateTree(node.getRight());
            }
            case "()" -> {
                return evaluateTree(node.getRight());
            }
            default -> {
                //                System.out.println(Double.parseDouble(node.getValue()));
                return Double.parseDouble(node.getValue());
            }
        }
    }
    private Node expressionToTree(String exp){

        int length = exp.length();
        int index  = -1;
        int parenthesesBegin = -1 , parenthesesEnd = -1, numberOfParentheses = 0;

        for (int i = 0; i < length; i++){
            char curentChar = exp.charAt(i);

            if(curentChar == '('){
                if (numberOfParentheses == 0)
                    parenthesesBegin = i;
                numberOfParentheses++;
            }
            else if(numberOfParentheses > 0){
                if (index == -1)
                    index = parenthesesBegin;
                if (curentChar == ')' && --numberOfParentheses == 0)
                    parenthesesEnd = i;
            }
            else if(isOper(curentChar)){
                if(index == -1)
                    index = i;
                else {
                    if(index != -1 && curentChar == '-' && isPrecededByOpre(exp.substring(index +1, i))){
                        continue;
                    }
                    else if (operatorDegree.get(exp.charAt(index)) > operatorDegree.get(curentChar))
                        index = i;
                }
            }
        }

        if (index == -1 && parenthesesBegin == parenthesesEnd ){
            return new Node(exp, null, null);
        }
        Node node;
        String leftExpr, rightExpr, oper = "" + exp.charAt(index);
        if (parenthesesBegin == index){
            rightExpr = exp.substring(parenthesesBegin +1, parenthesesEnd);
            node = new Node("()",null ,expressionToTree(rightExpr) );
        } else if (oper.equals("-") && isEmpty(exp.substring(0, index)) ) {
            rightExpr = exp.substring(index +1);
            node = new Node(oper, null, expressionToTree(rightExpr));
        }else {
            leftExpr  = exp.substring(0, index);
            rightExpr = exp.substring(index +1);
            node = new Node(oper, expressionToTree(leftExpr), expressionToTree(rightExpr));
        }
        //        System.out.println(node.getValue());
        return node;
    }
    /*
        check if a character is an arithmetic operator
     */
    private boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    private boolean isEmpty(String s){
        int i = -1;
        while (++i < s.length())
            if (s.charAt(i) != ' ' && s.charAt(i) != '(')
                return false;
        return true;
    }
    private boolean isPrecededByOpre(String s){
        int  length = s.length(), i = length;
        while (i-- > 0 ){
            if(s.charAt(i) == ' ' || s.charAt(i) == '(')
                continue;
            if(s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0)
                return false;
            if (s.charAt(i) == '/' || s.charAt(i) == '*')
                return true;
        }
        return true;

    }
    public static void main(String[] args) {
        MathEvaluator mathEvaluator = new MathEvaluator();

        double res = mathEvaluator.calculate("12* 123/-(-5 + 2)");

        System.out.println(res);
    }
}

class Node{
    private String value;
    private Node left, right;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}