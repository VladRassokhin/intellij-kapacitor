// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KapacitorChain extends PsiElement {

  @NotNull
  List<KapacitorChain> getChainList();

  @Nullable
  KapacitorFunction getFunction();

  @Nullable
  KapacitorIdentifier getIdentifier();

}
