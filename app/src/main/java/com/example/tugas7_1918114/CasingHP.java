package com.example.tugas7_1918114;

public class CasingHP {
    private String _id, _nama_casing, _harga;
    public CasingHP(String id, String _nama_casing, String _harga) {
        this._id = id;
        this._nama_casing = _nama_casing;
        this._harga = _harga;
    }
    public CasingHP() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama_casing() {
        return _nama_casing;
    };
    public void set_nama_casing(String _nama_casing) {
        this._nama_casing = _nama_casing;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
