# FJump

<!-- Plugin description -->

Based on [KJump](https://github.com/a690700752/KJump).

A simplify plugin ported from vim-EasyMotion plugin for Intellij Platform IDE. Can be integrated with IdeaVim.
Support character, word, line jump.

## Usage

There are no default activated shortcuts. You can assign FJump activation shortcuts in `Settings->Keymap->FJump` menu, 
such as `<c-,>` `<c-;>` etc, or integrate with IdeaVim by add below section in ~/.ideavimrc:

```vimrc
nmap <leader><leader>w :action FJumpAction.Word0<cr>
nmap <leader><leader>e :action FJumpAction.WordEnd<cr>
nmap <leader><leader>s :action FJumpAction<cr>
nmap <leader><leader>l :action FJumpAction.Line<cr>
// more action see table below
```

| Name           | Action              | Desc                                                              |
|----------------|---------------------|-------------------------------------------------------------------|
| FJump          | FJumpAction         | Input 1 character and jump to any same character.                 |
| FJump Char 2   | FJumpAction.Char2   | Input 2 character and jump to any same character.                 |
| FJump Word 0   | FJumpAction.Word0   | Jump to any word.                                                 |
| FJump Word 1   | FJumpAction.Word1   | Input 1 character and jump to any word start with this character. |
| FJump Line     | FJumpAction.Line    | Jump to any line.                                                 |
| FJump Word End | FJumpAction.WordEnd | Jump to any word end.                                             |

<!-- Plugin description end -->
