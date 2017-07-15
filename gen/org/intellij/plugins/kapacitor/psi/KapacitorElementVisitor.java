// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class KapacitorElementVisitor extends PsiElementVisitor {

  public void visitPrimaryFunc(@NotNull KapacitorPrimaryFunc o) {
    visitPsiElement(o);
  }

  public void visitStringList(@NotNull KapacitorStringList o) {
    visitPsiElement(o);
  }

  public void visitBooleanLiteral(@NotNull KapacitorBooleanLiteral o) {
    visitLiteral(o);
  }

  public void visitChain(@NotNull KapacitorChain o) {
    visitPsiElement(o);
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

  public void visitFunction(@NotNull KapacitorFunction o) {
    visitExpression(o);
  }

  public void visitIdentifier(@NotNull KapacitorIdentifier o) {
    visitPsiElement(o);
  }

  public void visitLambda(@NotNull KapacitorLambda o) {
    visitExpression(o);
  }

  public void visitLiteral(@NotNull KapacitorLiteral o) {
    visitPsiElement(o);
  }

  public void visitNumberLiteral(@NotNull KapacitorNumberLiteral o) {
    visitLiteral(o);
  }

  public void visitOperatorLiteral(@NotNull KapacitorOperatorLiteral o) {
    visitLiteral(o);
  }

  public void visitPrimaryExpr(@NotNull KapacitorPrimaryExpr o) {
    visitExpression(o);
  }

  public void visitPrimaryUnaryExpr(@NotNull KapacitorPrimaryUnaryExpr o) {
    visitPsiElement(o);
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

  public void visitStatement(@NotNull KapacitorStatement o) {
    visitPsiElement(o);
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
