namespace desafio_instituicao_wf.components;

public class TabelaDeDados : DataGridView
{
    // Inicializa um datagridbiee em uma determinada posicao
    public TabelaDeDados(int x, int y)
    {
        this.Location = new Point(x, y);
        this.Size = new Size(1440, 746);
        this.AutoSize = true;
        this.BackColor = Color.FromArgb(254, 254, 254);
        this.ForeColor = Color.FromArgb(0, 0, 0);
        this.Font = new Font("Regular", 8, FontStyle.Bold);
    }
}
