using UnityEngine;

/// <summary>
/// Reconstruction shell for the original `NoveMenu` UnityScript component.
/// </summary>
public class NoveMenuRecovered : MonoBehaviour
{
    public int zvolenum;
    public int jaz;
    public int vybranystart;
    public int vybranykonec;
    public bool zvolena;
    public bool zakryt;
    public bool nacitani;
    public string trasa;
    public string zacatek;
    public string konec;

    public void Start()
    {
        zvolenum = 0;
        zvolena = false;
        zakryt = false;
        nacitani = false;
    }

    public void zmenjazyk(int language)
    {
        jaz = language;
    }

    public void nactismerdepo()
    {
        trasa = "depo";
        nacitani = true;
    }

    public void nactismermotol()
    {
        trasa = "motol";
        nacitani = true;
    }

    public void animuj()
    {
        zakryt = !zakryt;
    }
}
