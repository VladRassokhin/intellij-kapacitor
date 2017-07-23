// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

public class TickScriptElementVisitor extends PsiElementVisitor {

  public void visitBinaryAdditionExpression(@NotNull TickScriptBinaryAdditionExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryAndExpression(@NotNull TickScriptBinaryAndExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryEqualityExpression(@NotNull TickScriptBinaryEqualityExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryExpression(@NotNull TickScriptBinaryExpression o) {
    visitExpression(o);
  }

  public void visitBinaryMultiplyExpression(@NotNull TickScriptBinaryMultiplyExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryOrExpression(@NotNull TickScriptBinaryOrExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryRelationalExpression(@NotNull TickScriptBinaryRelationalExpression o) {
    visitBinaryExpression(o);
  }

  public void visitChainAtExpression(@NotNull TickScriptChainAtExpression o) {
    visitChainExpression(o);
  }

  public void visitChainDotExpression(@NotNull TickScriptChainDotExpression o) {
    visitChainExpression(o);
  }

  public void visitChainExpression(@NotNull TickScriptChainExpression o) {
    visitBinaryExpression(o);
  }

  public void visitChainPipeExpression(@NotNull TickScriptChainPipeExpression o) {
    visitChainExpression(o);
  }

  public void visitLambdaExpression(@NotNull TickScriptLambdaExpression o) {
    visitExpression(o);
  }

  public void visitMethodCallExpression(@NotNull TickScriptMethodCallExpression o) {
    visitExpression(o);
  }

  public void visitParameterList(@NotNull TickScriptParameterList o) {
    visitPsiElement(o);
  }

  public void visitParenthesizedExpression(@NotNull TickScriptParenthesizedExpression o) {
    visitExpression(o);
  }

  public void visitStringList(@NotNull TickScriptStringList o) {
    visitExpression(o);
  }

  public void visitUnaryExpression(@NotNull TickScriptUnaryExpression o) {
    visitExpression(o);
  }

  public void visitBooleanLiteral(@NotNull TickScriptBooleanLiteral o) {
    visitLiteral(o);
  }

  public void visitDeclaration(@NotNull TickScriptDeclaration o) {
    visitPsiElement(o);
  }

  public void visitDurationLiteral(@NotNull TickScriptDurationLiteral o) {
    visitLiteral(o);
  }

  public void visitExpression(@NotNull TickScriptExpression o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull TickScriptIdentifier o) {
    visitExpression(o);
    // visitPsiNamedElement(o);
  }

  public void visitLiteral(@NotNull TickScriptLiteral o) {
    visitExpression(o);
  }

  public void visitNumberLiteral(@NotNull TickScriptNumberLiteral o) {
    visitLiteral(o);
  }

  public void visitReferenceLiteral(@NotNull TickScriptReferenceLiteral o) {
    visitLiteral(o);
  }

  public void visitRegexLiteral(@NotNull TickScriptRegexLiteral o) {
    visitLiteral(o);
  }

  public void visitStarLiteral(@NotNull TickScriptStarLiteral o) {
    visitLiteral(o);
  }

  public void visitStringLiteral(@NotNull TickScriptStringLiteral o) {
    visitLiteral(o);
  }

  public void visitTypeDeclaration(@NotNull TickScriptTypeDeclaration o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
