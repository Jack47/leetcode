bool canWinNim(int n) {
  if (n <=3) {
    return true;
  }
  else {
    return (n%4 != 0);
  }
}
