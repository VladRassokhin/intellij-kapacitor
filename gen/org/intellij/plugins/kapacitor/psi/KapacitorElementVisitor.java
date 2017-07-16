// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

public class KapacitorElementVisitor extends PsiElementVisitor {

  public void visitBinaryAdditionExpression(@NotNull KapacitorBinaryAdditionExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryAndExpression(@NotNull KapacitorBinaryAndExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryEqualityExpression(@NotNull KapacitorBinaryEqualityExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryExpression(@NotNull KapacitorBinaryExpression o) {
    visitExpression(o);
  }

  public void visitBinaryMultiplyExpression(@NotNull KapacitorBinaryMultiplyExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryOrExpression(@NotNull KapacitorBinaryOrExpression o) {
    visitBinaryExpression(o);
  }

  public void visitBinaryRelationalExpression(@NotNull KapacitorBinaryRelationalExpression o) {
    visitBinaryExpression(o);
  }

  public void visitChainAtExpression(@NotNull KapacitorChainAtExpression o) {
    visitChainExpression(o);
  }

  public void visitChainDotExpression(@NotNull KapacitorChainDotExpression o) {
    visitChainExpression(o);
  }

  public void visitChainExpression(@NotNull KapacitorChainExpression o) {
    visitBinaryExpression(o);
  }

  public void visitChainPipeExpression(@NotNull KapacitorChainPipeExpression o) {
    visitChainExpression(o);
  }

  public void visitLambdaExpression(@NotNull KapacitorLambdaExpression o) {
    visitExpression(o);
  }

  public void visitMethodCallExpression(@NotNull KapacitorMethodCallExpression o) {
    visitExpression(o);
  }

  public void visitParameterList(@NotNull KapacitorParameterList o) {
    visitPsiElement(o);
  }

  public void visitParenthesizedExpression(@NotNull KapacitorParenthesizedExpression o) {
    visitExpression(o);
  }

  public void visitStringList(@NotNull KapacitorStringList o) {
    visitExpression(o);
  }

  public void visitUnaryExpression(@NotNull KapacitorUnaryExpression o) {
    visitExpression(o);
  }

  public void visitBooleanLiteral(@NotNull KapacitorBooleanLiteral o) {
    visitLiteral(o);
  }

  public void visitDeclaration(@NotNull KapacitorDeclaration o) {
    visitPsiElement(o);
  }

  public void visitDurationLiteral(@NotNull KapacitorDurationLiteral o) {
    visitLiteral(o);
  }

  public void visitExpression(@NotNull KapacitorExpression o) {
    visitPsiElement(o);
  }

  public void visitIdentifier(@NotNull KapacitorIdentifier o) {
    visitExpression(o);
    // visitPsiNamedElement(o);
  }

  public void visitLiteral(@NotNull KapacitorLiteral o) {
    visitExpression(o);
  }

  public void visitNumberLiteral(@NotNull KapacitorNumberLiteral o) {
    visitLiteral(o);
  }

  public void visitReferenceLiteral(@NotNull KapacitorReferenceLiteral o) {
    visitLiteral(o);
  }

  public void visitRegexLiteral(@NotNull KapacitorRegexLiteral o) {
    visitLiteral(o);
  }

  public void visitStarLiteral(@NotNull KapacitorStarLiteral o) {
    visitLiteral(o);
  }

  public void visitStringLiteral(@NotNull KapacitorStringLiteral o) {
    visitLiteral(o);
  }

  public void visitTypeDeclaration(@NotNull KapacitorTypeDeclaration o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
