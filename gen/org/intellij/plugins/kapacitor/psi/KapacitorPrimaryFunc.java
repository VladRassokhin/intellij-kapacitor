// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KapacitorPrimaryFunc extends PsiElement {

  @NotNull
  KapacitorIdentifier getIdentifier();

  @NotNull
  List<KapacitorPrimaryExpr> getPrimaryExprList();

}
