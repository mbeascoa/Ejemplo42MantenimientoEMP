package com.example.ejemplo42;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    private List<Empleados> listaEmpleados;

    public Adaptador(List<Empleados> ListaEmpleados) {
        this.listaEmpleados = ListaEmpleados;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_datos, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String nombre = listaEmpleados.get(position).getNombre();
        String apellido = listaEmpleados.get(position).getApellido();
        int codigo = listaEmpleados.get(position).getCodigo();


        holder.txtempleado.setText(nombre + " " + apellido);

        holder.txtempleado.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int codigo = listaEmpleados.get(position).getCodigo();
                Intent i = new Intent(holder.itemView.getContext(), VentanaDetalle.class );
                i.putExtra("codigo",codigo);
                holder.itemView.getContext().startActivity(i);


            }
        });


    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtempleado;
        public ViewHolder(View v) {
            super(v);
            txtempleado = (TextView) v.findViewById(R.id.txtEmpleado);
        }
    }

}
