using UnityEngine;

/// <summary>
/// First reconstruction shell for the original UnityScript class `Rekonstrukce`.
///
/// The field names mirror the recovered managed assembly so serialized scene
/// references can be reconnected gradually. Behaviour is intentionally small
/// and explicit until the original method bodies have been reconstructed.
/// </summary>
public class RekonstrukceRecovered : MonoBehaviour
{
    public float updateInterval = 0.5f;
    public float rychlost;
    public float akcelerace;
    public bool menu;
    public bool vestanici;
    public bool dvereotevrene;
    public bool jsoudvereotevrene;
    public bool systemaktivni;
    public bool povolitjizdu;
    public bool vlozenakarta;
    public bool troubim;

    public GameObject kabina;
    public GameObject BusePanel;
    public GameObject[] vsechnybody;
    public StationPoint[] stanicee;

    public Transform lever0;
    public Transform leverb;
    public Transform leverbp;
    public Transform leverj;
    public Transform leverjp;

    public Transform LLdvere;
    public Transform LPdvere;
    public Transform PLdvere;
    public Transform PPdvere;

    public TextMesh disp2;
    public TextMesh dispdo;
    public TextMesh dispdc;
    public TextMesh dispBinbows;
    public TextMesh dispWappo;
    public TextMesh tachop;

    public AudioSource zvukmotor;
    public AudioSource zvukmenice;
    public AudioSource klaksonsta;
    public AudioSource klaksonmid;
    public AudioSource klaksonsto;
    public AudioSource OpDvereZvuk;
    public AudioSource ClDvereZvuk;
    public AudioSource rozhlas;

    public Light svetloKabiny;
    public Light svetlokabiny;
    public Light svetlowas;

    private float targetSpeed;
    private bool openingLeft;
    private bool openingRight;

    public void Start()
    {
        systemaktivni = true;
        povolitjizdu = false;
        dvereotevrene = false;
        jsoudvereotevrene = false;
        rychlost = 0f;
        akcelerace = 0f;
        targetSpeed = 0f;
    }

    public void Update()
    {
        if (!systemaktivni || menu)
        {
            return;
        }

        UpdateSpeed();
        UpdateDoors();
        UpdateDisplays();
    }

    private void UpdateSpeed()
    {
        if (!povolitjizdu || dvereotevrene || !vlozenakarta)
        {
            targetSpeed = 0f;
        }

        float delta = targetSpeed - rychlost;
        akcelerace = Mathf.Clamp(delta * 0.75f, -1f, 1f);
        rychlost = Mathf.MoveTowards(rychlost, targetSpeed, Mathf.Abs(akcelerace) * Time.deltaTime * 12f);

        if (zvukmotor != null)
        {
            zvukmotor.pitch = 0.8f + Mathf.Abs(rychlost) * 0.02f;
        }
    }

    private void UpdateDoors()
    {
        if (openingLeft)
        {
            MoveDoor(LLdvere, -1f);
            MoveDoor(LPdvere, -1f);
        }

        if (openingRight)
        {
            MoveDoor(PLdvere, 1f);
            MoveDoor(PPdvere, 1f);
        }
    }

    private void MoveDoor(Transform door, float direction)
    {
        if (door == null)
        {
            return;
        }

        door.localPosition += Vector3.right * direction * Time.deltaTime * 0.35f;
    }

    private void UpdateDisplays()
    {
        if (tachop != null)
        {
            tachop.text = Mathf.RoundToInt(rychlost).ToString();
        }

        if (disp2 != null)
        {
            disp2.text = systemaktivni ? "SYSTEM OK" : "SYSTEM OFF";
        }
    }

    public void Selftest()
    {
        systemaktivni = true;
        if (disp2 != null)
        {
            disp2.text = "SELFTEST";
        }
    }

    public void Selftest2()
    {
        if (disp2 != null)
        {
            disp2.text = "READY";
        }
    }

    public void otevriLeve()
    {
        if (rychlost > 0.1f)
        {
            return;
        }

        openingLeft = true;
        openingRight = false;
        dvereotevrene = true;
        jsoudvereotevrene = true;
        if (OpDvereZvuk != null)
        {
            OpDvereZvuk.Play();
        }
    }

    public void otevriPrave()
    {
        if (rychlost > 0.1f)
        {
            return;
        }

        openingLeft = false;
        openingRight = true;
        dvereotevrene = true;
        jsoudvereotevrene = true;
        if (OpDvereZvuk != null)
        {
            OpDvereZvuk.Play();
        }
    }

    public void zavriLeve()
    {
        openingLeft = false;
        dvereotevrene = false;
        jsoudvereotevrene = false;
        if (ClDvereZvuk != null)
        {
            ClDvereZvuk.Play();
        }
    }

    public void zavriPrave()
    {
        openingRight = false;
        dvereotevrene = false;
        jsoudvereotevrene = false;
        if (ClDvereZvuk != null)
        {
            ClDvereZvuk.Play();
        }
    }

    public void vlozKartu()
    {
        vlozenakarta = true;
        povolitjizdu = true;
        Selftest2();
    }

    public void vlozKartu2()
    {
        vlozKartu();
    }

    public void vlozKartu3()
    {
        vlozKartu();
    }

    public void vlozKartu4()
    {
        vlozKartu();
    }

    public void svetla()
    {
        if (svetloKabiny != null)
        {
            svetloKabiny.enabled = !svetloKabiny.enabled;
        }

        if (svetlokabiny != null)
        {
            svetlokabiny.enabled = !svetlokabiny.enabled;
        }
    }

    public void kla1()
    {
        Klaksonstart();
    }

    public void Klaksonstart()
    {
        if (klaksonmid != null)
        {
            klaksonmid.Play();
        }
    }

    public void Klaksonstop()
    {
        if (klaksonmid != null)
        {
            klaksonmid.Stop();
        }
    }

    public void pauza()
    {
        Time.timeScale = Time.timeScale > 0f ? 0f : 1f;
    }

    public void ZobrazReklamu()
    {
        Debug.Log("Recovered ad hook: original implementation not available.");
    }
}
